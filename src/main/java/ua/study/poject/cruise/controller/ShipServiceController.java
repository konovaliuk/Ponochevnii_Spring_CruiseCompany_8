package ua.study.poject.cruise.controller;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;
        import ua.study.poject.cruise.persistance.entity.Service;
        import ua.study.poject.cruise.persistance.entity.Ship;
        import ua.study.poject.cruise.service.ShipService;
        import ua.study.poject.cruise.service.ShipserviceService;

        import java.util.List;

@Controller
@SessionAttributes({"addShipServiceToShipMessage", "addshipservicestosystemMessage", "allServicesInSystem",
        "selectedservice", "sship", "allShips", "allServicesOnSelectedShip"})

public class ShipServiceController {

    @Autowired
    ShipserviceService shipserviceService;

    @Autowired
    ShipService shipService;


    // Add services to ship
    @GetMapping("/addshipservicetoship")
    public String addShipServicesToShipGet(Model model) {
        model.addAttribute("allShips", shipService.getAllShips());
        return "addshipservicetoship";
    }

    @PostMapping("/addshipservicetoship")
    public String addShipServicesToShipPost(Model model, Long selectedservice, @RequestParam Long selectedship, @RequestParam Integer payable) {

        Ship ship = shipService.getShipById(selectedship);
        if (ship == null) {
            model.addAttribute("addShipServiceToShipMessage", "message.addshipservicetoship.errorshipnotfound");
            return "addshipservicetoship";
        }
        model.addAttribute("sship", ship);

        model.addAttribute("allServicesInSystem", shipserviceService.getAllServisesInSystem());
        model.addAttribute("selectedservice", shipService.getAllServicesByShipId(selectedship));
        model.addAttribute("allServicesOnSelectedShip", shipService.getAllServicesByShipId(ship.getId()));

        if (selectedservice == null) {
//            model.addAttribute("addShipServiceToShipMessage", "message.addshipservicetoship.error2");
            return "addshipservicetoship";
        }

        model.addAttribute("addShipServiceToShipMessage", shipserviceService.addServiceToShip(selectedservice, selectedship, payable));
        model.addAttribute("allServicesOnSelectedShip", shipService.getAllServicesByShipId(ship.getId()));
        return "redirect:/addshipservicetoship";
    }


    // Add services to system
    @GetMapping("/addshipservicestosystem")
    public String addShipServicesToSystem(Model model) {
        model.addAttribute("allServices", shipserviceService.getAllServisesInSystem());
        return "addshipservicestosystem";
    }

    @PostMapping("/addshipservicestosystem")
    public String addShipServicesToSystem(Service newService, Model model) {
        model.addAttribute("addshipservicestosystemMessage", shipserviceService.addNewServiceToSystem(newService));
        return "redirect:/addshipservicestosystem";
    }

    @PostMapping("/deleteshipservicefromship")
    public String deleteServicesFromShipPost(Model model, @RequestParam("selectedship") Long selectedShipId, @RequestParam("shipservice") List<Long> servicesIdList,
                                             @SessionAttribute List<Ship> allShips) {

        final String SSHIPS = "sship";
        final String ALL_SERVICES_ON_SELECTED_SHIP = "allServicesOnSelectedShip";
        final String ALL_SERVICES_IN_SYSTEM = "allServicesInSystem";

        for (Ship ship : allShips) {
            if (ship.getId().equals(selectedShipId)) {
                model.addAttribute(SSHIPS, ship);
                break;
            }
        }

        shipserviceService.deleteServicesFromShip(selectedShipId, servicesIdList);

        model.addAttribute(ALL_SERVICES_ON_SELECTED_SHIP, shipService.getAllServicesByShipId(selectedShipId)); // отправляем в jsp список всех сервисов, уже добавленых к выбранному кораблю
        model.addAttribute(ALL_SERVICES_IN_SYSTEM, shipserviceService.getAllServisesInSystem()); // отправляем в jsp список всех сервисов в системе

        return "redirect:/addshipservicetoship";
    }




}
