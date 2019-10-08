package ua.study.poject.cruise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.study.poject.cruise.persistance.dao.IPrintableCruise;
import ua.study.poject.cruise.persistance.dao.ITicket;
import ua.study.poject.cruise.persistance.dao.ITicketExcursion;
import ua.study.poject.cruise.persistance.entity.Ticket;
import ua.study.poject.cruise.persistance.entity.TicketExcursion;
import ua.study.poject.cruise.persistance.entity.User;
import ua.study.poject.cruise.persistance.entity.printableentity.PrintableCruise;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a class that contains logic for working with purchase history
 */
@Service
public class PurchaseService {

    @Autowired
    IPrintableCruise printableCruiseImpl;

    @Autowired
    ITicket ticketImpl;

    @Autowired
    ITicketExcursion ticketExcursionImpl;

    /**
     * This method finds all Cruises that were purchased by the user
     *
     * @param user current user
     * @return List of PrintableCruise or empty list if the search was unsuccessful
     */
    public List<PrintableCruise> findMyPrintableCruises(User user) {
        List<PrintableCruise> list = new ArrayList<>();
        for (Ticket myCruiseTicket : ticketImpl.findTicketByUser(user)) {
            list.add(printableCruiseImpl.findPrintableCruiseByCruiseId(myCruiseTicket.getCruise().getId()));
        }
        return list;
    }

    /**
     * This method finds all Excursions that were purchased by the user
     *
     * @param user current user
     * @return List of TicketExcursion or empty list if the search was unsuccessful
     */
    public List<TicketExcursion> findMyExcursions(User user) {
        return ticketExcursionImpl.findAllByUser(user);

    }
}
