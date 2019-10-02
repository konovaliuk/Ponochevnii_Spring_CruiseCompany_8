package ua.study.poject.cruise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.study.poject.cruise.persistance.dao.IPrintableCruise;
import ua.study.poject.cruise.persistance.entity.Ship;
import ua.study.poject.cruise.persistance.entity.TicketclassBonus;
import ua.study.poject.cruise.persistance.entity.User;
import ua.study.poject.cruise.persistance.entity.dto.DtoCruisePorts;
import ua.study.poject.cruise.persistance.dao.ICruisePorts;
import ua.study.poject.cruise.persistance.entity.printableentity.PrintableCruise;
import ua.study.poject.cruise.service.*;

import java.util.List;

import static ua.study.poject.cruise.persistance.entity.Ticketclass.*;
import static ua.study.poject.cruise.persistance.entity.Ticketclass.TICKET_CLASS_FOURTH;

@Controller
@SessionAttributes({"createcruiseMessage", "allPorts", "allShips", "viewcruiseMessage", "allBonusesForTicketClass1",
        "allBonusesForTicketClass2", "allBonusesForTicketClass3", "allBonusesForTicketClass4", "cruise", "currentuser"})
public class CruiseController {

    @Autowired
    CruiseService cruiseServiceImpl;

    @Autowired
    PortExcursionService portExcursionService;

    @Autowired
    ShipService shipService;

    @Autowired
    IPrintableCruise printableCruise;

    @Autowired
    ManagerAndBonuseService managerAndBonuseService;

    @Autowired
    PurchaseService purchaseService;


    @GetMapping("/viewcruise")
    public String createPort(Model model, @RequestParam Long selectedCruiseId) {

        PrintableCruise selectedPrintableCruise = printableCruise.findPrintableCruiseByCruiseId(selectedCruiseId);
        if (selectedPrintableCruise == null)
            return "redirect:/startpage";
        model.addAttribute("cruise", selectedPrintableCruise);

// список услуг на данном корабле
        model.addAttribute("shipserviceList", shipService.getAllServicesByShipId(selectedPrintableCruise.getCruise().getShip().getId())); // PrintableServiceOnShip


// списки бонусв для каждого класса билетов
        List<TicketclassBonus> ticketclassBonusListFirstClass = managerAndBonuseService.getAllBonusesByCruiseIdTicketclassName(selectedCruiseId, TICKET_CLASS_FIRST);
        model.addAttribute("allBonusesForTicketClass1", ticketclassBonusListFirstClass);

        List<TicketclassBonus> ticketclassBonusListSecondClass = managerAndBonuseService.getAllBonusesByCruiseIdTicketclassName(selectedCruiseId, TICKET_CLASS_SECOND);
        model.addAttribute("allBonusesForTicketClass2", ticketclassBonusListSecondClass);

        List<TicketclassBonus> ticketclassBonusListThirdClass = managerAndBonuseService.getAllBonusesByCruiseIdTicketclassName(selectedCruiseId, TICKET_CLASS_THIRD);
        model.addAttribute("allBonusesForTicketClass3", ticketclassBonusListThirdClass);

        List<TicketclassBonus> ticketclassBonusListFourthClass = managerAndBonuseService.getAllBonusesByCruiseIdTicketclassName(selectedCruiseId, TICKET_CLASS_FOURTH);
        model.addAttribute("allBonusesForTicketClass4", ticketclassBonusListFourthClass);

        return "viewcruise";
    }




    @GetMapping("/createcruise")
    public String createCruiseGet(Model model) {
        model.addAttribute("allPorts", portExcursionService.getAllPorts());
        model.addAttribute("allShips", shipService.getAllShips());
        return "createcruise";
    }



    @PostMapping("/createcruise")
    public String createCruisePost(DtoCruisePorts dtoCruisePorts, @RequestParam("selectedship") Long selectedship, Model model) {
        Ship tempShip = new Ship();
        tempShip.setId(selectedship);
        dtoCruisePorts.setSelectedship(tempShip);

        model.addAttribute("createcruiseMessage", cruiseServiceImpl.createCruise(dtoCruisePorts));
        return "redirect:/createcruise";
    }

    @GetMapping("/viewmycruises")
    public String createPort(Model model, @SessionAttribute User currentuser) {
        model.addAttribute("myPrintableCruises", purchaseService.findMyPrintableCruises(currentuser));
        model.addAttribute("myExcursions", purchaseService.findMyExcursions(currentuser));
        return "viewmycruises";
    }
}
