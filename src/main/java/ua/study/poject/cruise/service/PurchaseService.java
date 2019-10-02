package ua.study.poject.cruise.service;

import org.apache.log4j.Logger;
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

@Service
public class PurchaseService {

    @Autowired
    IPrintableCruise printableCruiseImpl;

    @Autowired
    ITicket ticketImpl;

    @Autowired
    ITicketExcursion ticketExcursionImpl;


    private static final Logger LOGGER = Logger.getLogger(PurchaseService.class);

    public List<PrintableCruise> findMyPrintableCruises(User user) {
        List<PrintableCruise> list = new ArrayList<>();
        for (Ticket myCruiseTicket : ticketImpl.findTicketByUser(user))
            list.add(printableCruiseImpl.findPrintableCruiseByCruiseId(myCruiseTicket.getCruise().getId()));

        return list;
    }

    public List<TicketExcursion> findMyExcursions(User user) {
        return ticketExcursionImpl.findAllByUser(user);

    }
}
