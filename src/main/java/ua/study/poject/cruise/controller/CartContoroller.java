package ua.study.poject.cruise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.study.poject.cruise.persistance.entity.Excursion;
import ua.study.poject.cruise.persistance.entity.Ticketclass;
import ua.study.poject.cruise.persistance.entity.User;
import ua.study.poject.cruise.persistance.entity.printableentity.PrintableCruise;
import ua.study.poject.cruise.service.CartPayService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes({"cruisesInCart", "viewcartMessage", "currentuser", "ticketclassesInCart", "excurisionsInCart", "viewcruiseMessage", "viewexcursionMessage", "allTicketClasses", "allCruises", "allExcursions"})
public class CartContoroller {

    @Autowired
    CartPayService cartPayService;

    private final String CRUISES_IN_CART = "cruisesInCart";
    private final String TICKET_CLASSES_IN_CART = "ticketclassesInCart";
    private final String EXCURSIONS_IN_CART = "excurisionsInCart";
    private final String VIEW_CRUISE_MESSAGE = "viewcruiseMessage";
    private final String VIEW_EXCURSION_MESSAGE = "viewexcursionMessage";
    private final String VIEW_CART_MESSAGE = "viewcartMessage";

    @GetMapping("/viewcart")
    public String createPort() {
        return "viewcart";
    }

    @PostMapping("/addtocart/excursion")
    public String addToCartExcursion(Model model,
                                     @SessionAttribute List<Excursion> excurisionsInCart,
                                     @SessionAttribute List<Excursion> allExcursions,
                                     @RequestParam Long excursionIdToCart) {

        for (Excursion currentExcursion : allExcursions) {
            if (currentExcursion.getId().equals(excursionIdToCart)) {
                excurisionsInCart.add(currentExcursion);
                model.addAttribute(VIEW_EXCURSION_MESSAGE, "message.addtocart.excuradded");
                return "redirect:/viewexcursion?viewExcursionId=" + excursionIdToCart;
            }
        }
        model.addAttribute(VIEW_EXCURSION_MESSAGE, "message.addtocart.erraddexcur"); // TODO errorPage
        return "redirect:/viewexcursion?viewExcursionId=" + excursionIdToCart;
    }

    @PostMapping("/addtocart/cruise")
    public String addToCartCruise(Model model,
                                  @SessionAttribute List<PrintableCruise> allCruises,
                                  @SessionAttribute List<Ticketclass> allTicketClasses,
                                  @SessionAttribute List<PrintableCruise> cruisesInCart,
                                  @SessionAttribute List<Ticketclass> ticketclassesInCart,
                                  @RequestParam Long cruiseIdToCart,
                                  @RequestParam String ticketclassForm) {

        for (PrintableCruise currentCruise : allCruises)
            if (currentCruise.getCruise().getId().equals(cruiseIdToCart))
                cruisesInCart.add(currentCruise);

        for (Ticketclass currentTicketclass : allTicketClasses) {
            if (currentTicketclass.getTicketclassName().equals(ticketclassForm)) {
                ticketclassesInCart.add(currentTicketclass);
                model.addAttribute(VIEW_CRUISE_MESSAGE, "message.addtocart.cruiseadded");
                model.addAttribute("selectedCruiseId", cruiseIdToCart);
                return "redirect:/viewcruise?selectedCruiseId=" + cruiseIdToCart;
            }
        }

        model.addAttribute(VIEW_CRUISE_MESSAGE, "message.addtocart.erraddcruise"); // TODO errorPage
        return "redirect:/viewcruise?selectedCruiseId=" + cruiseIdToCart;
    }

    @PostMapping("/pay")
    public String payPost(Model model,
                          @SessionAttribute List<Excursion> excurisionsInCart,
                          @SessionAttribute List<PrintableCruise> cruisesInCart,
                          @SessionAttribute List<Ticketclass> ticketclassesInCart,
                          @SessionAttribute User currentuser) {

        Map<Boolean, String> result = cartPayService.pay(currentuser, cruisesInCart, ticketclassesInCart, excurisionsInCart);
        if (result.containsKey(true)) {
            model.addAttribute(CRUISES_IN_CART, new ArrayList<PrintableCruise>());
            model.addAttribute(TICKET_CLASSES_IN_CART, new ArrayList<Ticketclass>());
            model.addAttribute(EXCURSIONS_IN_CART, new ArrayList<Excursion>());
            model.addAttribute(VIEW_CART_MESSAGE, result.get(true));
        } else
            model.addAttribute(VIEW_CART_MESSAGE, result.get(false));

        return "redirect:/viewcart";
    }


    @PostMapping("/deletefromcart/excursion")
    public String DeleteFromCartExcursionPost(Model model,
                                              @SessionAttribute List<Excursion> excurisionsInCart,
                                              @RequestParam Long deleteexcursionfromcartForm) {

        for (int i = 0; i < excurisionsInCart.size(); i++) {
            if (excurisionsInCart.get(i).getId().equals(deleteexcursionfromcartForm)) {
                excurisionsInCart.remove(i);
                model.addAttribute(VIEW_CART_MESSAGE, "message.deletefromcart.delexcurok");
                return "redirect:/viewcart";
            }
        }
        model.addAttribute(VIEW_CART_MESSAGE, "message.deletefromcart.excurnotfound");
        return "redirect:/viewcart";
    }

    @PostMapping("/deletefromcart/cruise")
    public String DeleteFromCartCruisePost(Model model,
                                           @SessionAttribute List<PrintableCruise> cruisesInCart,
                                           @SessionAttribute List<Ticketclass> ticketclassesInCart,
                                           @RequestParam Long deletecruisefromcartForm) {

        for (int i = 0; i < cruisesInCart.size(); i++) {
            if (cruisesInCart.get(i).getCruise().getId().equals(deletecruisefromcartForm)) {
                cruisesInCart.remove(i);
                ticketclassesInCart.remove(i);
                model.addAttribute(VIEW_CART_MESSAGE, "message.deletefromcart.delcruise");
                return "redirect:/viewcart";
            }
        }
        model.addAttribute(VIEW_CART_MESSAGE, "message.deletefromcart.cruisenotfound");
        return "redirect:/viewcart";
    }

    @PostMapping("/deletefromcart/all")
    public String DeleteFromCartAllPost(Model model) {

        model.addAttribute(CRUISES_IN_CART, new ArrayList<PrintableCruise>());
        model.addAttribute(TICKET_CLASSES_IN_CART, new ArrayList<Ticketclass>());
        model.addAttribute(EXCURSIONS_IN_CART, new ArrayList<Excursion>());
        model.addAttribute(VIEW_CART_MESSAGE, "message.deletefromcart.cruisenotfound");
        return "redirect:/viewcart";
    }


}
