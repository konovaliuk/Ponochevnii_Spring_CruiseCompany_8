package ua.study.poject.cruise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.study.poject.cruise.persistance.entity.Ship;
import ua.study.poject.cruise.service.ShipService;
import ua.study.poject.cruise.service.ShipserviceService;

@Controller
@SessionAttributes({"errorMessage", "allServicesInSystem", "selectedservice", "sship", "allShips", "allServicesOnSelectedShip"})
public class DeleteServicesFromShipController {
    @Autowired
    ShipserviceService shipserviceService;

    @Autowired
    ShipService shipService;

    @PostMapping("/deleteshipservicefromship")
    public String deleteServicesFromShipPost(Model model, Long selectedservice, @RequestParam Long selectedship,
                                                 @RequestParam Integer payable) {




        model.addAttribute("errorMessage", shipserviceService.addServiceToShip(selectedservice, selectedship, payable));
        return "redirect:/addshipservicetoship";
    }


}





//import static ua.study.poject.cruise.util.StringStorage.*;
//@Component
//public class DeleteShipServicesFromShip implements Action {
//    @Autowired
//    ShipserviceService shipserviceService;
//
//    @Autowired
//    ShipService shipService;
//
//    @Override
//    public String execute(HttpServletRequest request, HttpServletResponse response) {
//
//        final String MESSAGE = "errorMessage";
//        final String ALL_SHIPS = "allShips";
//        final String SSHIPS = "sship";
//        final String ALL_SERVICES_ON_SELECTED_SHIP = "allServicesOnSelectedShip";
//        final String ALL_SERVICES_IN_SYSTEM = "allServicesInSystem";
//
//        if (request.getSession(false) == null) {  // нет сессии - логинимся
//            return ConfigurationManager.getProperty("path.page.signin");
//        }
//
//
//        List<Ship> listShip = shipService.getAllShips();
//        request.getSession().setAttribute(ALL_SHIPS, listShip); // отправляем в jsp список всех кораблей
//
//        String selectedShip = request.getParameter(SELECTED_SHIP);
//        if (selectedShip == null || selectedShip.equals("")) {
//            request.getSession().setAttribute(MESSAGE, "message.addshipservicetoship.advert");
//            return ConfigurationManager.getProperty("path.page.addshipservicetoship");
//        }
//
//        Long selectedShipId;
//        try {
//            selectedShipId = Long.parseLong(selectedShip);
//            for (Ship ship : listShip) {
//                if (ship.getId().equals(selectedShipId)) {
//                    request.getSession().setAttribute(SSHIPS, ship);
//                    break;
//                }
//            }
//            request.getSession().setAttribute(SELECT_SHIP_SERVICES_FORM, SELECT_SHIP_SERVICES_FORM);
//        } catch (NumberFormatException e) {
//            request.getSession().setAttribute(MESSAGE, "message.addshipservicetoship.errorshipnotfound");
//            return ConfigurationManager.getProperty("path.page.addshipservicetoship");
//        }
//
//        List<Long> servicesIdList = new ArrayList<>();
//        int result;
//        String[] shipServicesArray = request.getParameterValues(SHIP_SERVICE);
//        if(shipServicesArray == null){
//            request.getSession().setAttribute(MESSAGE, "message.addshipservicetoship.errorservicenotfound");
//            return ConfigurationManager.getProperty("path.page.addshipservicetoship");
//        }
//        try {
//            for (String tempStr : shipServicesArray) {
//                servicesIdList.add(Long.parseLong(tempStr));
//            }
//            result = shipserviceService.deleteServicesFromShip(selectedShipId, servicesIdList);
//        } catch (NumberFormatException e) {
//            request.getSession().setAttribute(MESSAGE, "message.addshipservicetoship.errorservicenotfound");
//            return ConfigurationManager.getProperty("path.page.addshipservicetoship");
//        }
//        if (result == 0) {
//            request.getSession().setAttribute(MESSAGE, "message.addshipservicetoship.errdelete");
//        } else
//            request.getSession().setAttribute(MESSAGE, "message.addshipservicetoship.delok");
//
//        request.getSession().setAttribute(ALL_SERVICES_ON_SELECTED_SHIP, shipService.getAllServicesByShipId(selectedShipId)); // отправляем в jsp список всех сервисов, уже добавленых к выбранному кораблю
//        request.getSession().setAttribute(ALL_SERVICES_IN_SYSTEM, shipserviceService.getAllServisesInSystem()); // отправляем в jsp список всех сервисов в системе
//
//        return ConfigurationManager.getProperty("path.page.addshipservicetoship");
//    }
//}
