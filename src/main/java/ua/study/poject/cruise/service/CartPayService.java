package ua.study.poject.cruise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.study.poject.cruise.persistance.dao.ITicket;
import ua.study.poject.cruise.persistance.dao.ITicketExcursion;
import ua.study.poject.cruise.persistance.entity.*;
import ua.study.poject.cruise.persistance.entity.printableentity.PrintableCruise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CartPayService {


    @Autowired
    ITicketExcursion ticketExcursionImpl;

    @Autowired
    ITicket ticketImpl;

    @Transactional
    public Map<Boolean, String> pay(User user, List<PrintableCruise> cruisesInCart, List<Ticketclass> ticketclassesInCart, List<Excursion> excurisionsInCart) {

        Map<Boolean, String> result = new HashMap<>();
        result.put(false, "message.pay.errpay");
        if (cruisesInCart.size() != 0)
            for (int i = 0; i < cruisesInCart.size(); i++) {
                Ticket ticket = new Ticket(user, cruisesInCart.get(i).getCruise(), ticketclassesInCart.get(i));
                ticketImpl.create(ticket);
                if (ticket.getId() == null)
                    return result;
            }

        if (excurisionsInCart.size() != 0)
            for (Excursion excursion : excurisionsInCart) {
                TicketExcursion ticketExcursion = new TicketExcursion(excursion, user);
                ticketExcursionImpl.create(ticketExcursion);
                if (ticketExcursion.getId() == null)
                    return result;
            }
        result.remove(false);
        result.put(true, "message.pay.ok");
        return result;
    }
}
