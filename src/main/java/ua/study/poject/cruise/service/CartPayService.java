package ua.study.poject.cruise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.study.poject.cruise.persistance.dao.ITicket;
import ua.study.poject.cruise.persistance.dao.ITicketExcursion;
import ua.study.poject.cruise.persistance.entity.*;
import ua.study.poject.cruise.persistance.entity.printableentity.PrintableCruise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class that executes logic related to payment for purchases that are added to the cart
 */
@Service
public class CartPayService {


    @Autowired
    ITicketExcursion ticketExcursionImpl;

    @Autowired
    ITicket ticketImpl;

    /**
     * The pay method records everything the user has bought and empties the basket.
     * The method is organized transactional, because records have to be done
     * in several tables at the same time
     *
     * @param user                User who buys a Cruise or Excursion
     * @param cruisesInCart       List of Cruises added to Cart
     * @param ticketclassesInCart List of ticket classes that match cruises purchased
     * @param excurisionsInCart   List of excursions that the user added to the cart
     * @return a map with one element. If "Key" = true, then the operation was successful. "Value" - is message to user
     */
    @Transactional
    public Map<Boolean, String> pay(User user, List<PrintableCruise> cruisesInCart, List<Ticketclass> ticketclassesInCart, List<Excursion> excurisionsInCart) {

        Map<Boolean, String> result = new HashMap<>();
        result.put(false, "message.pay.errpay");
        if (cruisesInCart.size() != 0)
            for (int i = 0; i < cruisesInCart.size(); i++) {
                Ticket ticket = new Ticket(user, cruisesInCart.get(i).getCruise(), ticketclassesInCart.get(i));
                ticketImpl.create(ticket);
                if (ticket.getId() == null) {
                    return result;
                }
            }

        if (excurisionsInCart.size() != 0)
            for (Excursion excursion : excurisionsInCart) {
                TicketExcursion ticketExcursion = new TicketExcursion(excursion, user);
                ticketExcursionImpl.create(ticketExcursion);
                if (ticketExcursion.getId() == null) {
                    return result;
                }
            }
        result.remove(false);
        result.put(true, "message.pay.ok");
        return result;
    }
}
