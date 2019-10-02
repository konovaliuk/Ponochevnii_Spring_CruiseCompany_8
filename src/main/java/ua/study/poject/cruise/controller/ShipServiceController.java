package ua.study.poject.cruise.controller;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;
        import ua.study.poject.cruise.persistance.entity.Service;
        import ua.study.poject.cruise.persistance.entity.Ship;
        import ua.study.poject.cruise.service.ShipService;
        import ua.study.poject.cruise.service.ShipserviceService;

@Controller
@RequestMapping("/addshipservicetoship")
@SessionAttributes({"addShipServiceToShipMessage", "addshipservicestosystemMessage", "allServicesInSystem", "selectedservice", "sship", "allShips", "allServicesOnSelectedShip"})
public class ShipServiceController {
    @Autowired
    ShipserviceService shipserviceService;

    @Autowired
    ShipService shipService;


    // Add services to ship
    @GetMapping
    public String addShipServicesToShipGet(Model model) {
        model.addAttribute("allShips", shipService.getAllShips());
        return "addshipservicetoship";
    }

    @PostMapping
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

}
