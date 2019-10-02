package ua.study.poject.cruise.persistance.dao;


import ua.study.poject.cruise.persistance.entity.TicketExcursion;
import ua.study.poject.cruise.persistance.entity.User;

import java.util.List;

public interface ITicketExcursion {


    TicketExcursion create(TicketExcursion ticketExcursion);

    List<TicketExcursion> findAllByUser(User user);
}
