package ua.study.poject.cruise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import ua.study.poject.cruise.persistance.entity.Excursion;
import ua.study.poject.cruise.persistance.entity.Ticketclass;
import ua.study.poject.cruise.persistance.entity.printableentity.PrintableCruise;
import ua.study.poject.cruise.service.CruiseService;
import ua.study.poject.cruise.service.ManagerAndBonuseService;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@SessionAttributes({"startpageMessage", "allTicketClasses", "allCruises", "cruisesInCart", "ticketclassesInCart", "excurisionsInCart"})
public class MainController {

    @Autowired
    CruiseService cruiseService;

    @Autowired
    ManagerAndBonuseService managerAndBonuseService;

    @GetMapping("/")
    public String startPage() {
        return "redirect:/startpage";
    }

    @GetMapping("/startpage")
    public String startPage(Model model,
                            @SessionAttribute Optional<ArrayList<Ticketclass>> ticketclassesInCart,
                            @SessionAttribute Optional<ArrayList<Excursion>> excurisionsInCart,
                            @SessionAttribute Optional<ArrayList<PrintableCruise>> cruisesInCart) {

        model.addAttribute("allTicketClasses", managerAndBonuseService.getAllTicketclass());
        model.addAttribute("allCruises", cruiseService.viewAllPrintableCruises());

        if (!cruisesInCart.isPresent()) {
            model.addAttribute("cruisesInCart", new ArrayList<PrintableCruise>());
        }
        if (!ticketclassesInCart.isPresent()) {
            model.addAttribute("ticketclassesInCart", new ArrayList<Ticketclass>());
        }
        if (!excurisionsInCart.isPresent()) {
            model.addAttribute("excurisionsInCart", new ArrayList<Excursion>());
        }
        return "startpage";
    }
}
