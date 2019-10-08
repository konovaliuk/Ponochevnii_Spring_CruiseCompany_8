package ua.study.poject.cruise.persistance.dao;


import ua.study.poject.cruise.persistance.entity.TicketExcursion;
import ua.study.poject.cruise.persistance.entity.User;

import java.util.List;

/**
 * The interface ITicketExcursion defines an interaction contract with a TicketExcursion entity
 */
public interface ITicketExcursion {

    /**
     * The create method saves the new TicketExcursion entity, which is passed to it as a parameter
     *
     * @param ticketExcursion
     * @return updated TicketExcursion object that has a relevant "id"
     */
    TicketExcursion create(TicketExcursion ticketExcursion);

    /**
     * The method findAllByUser allows find all of the TicketExcursions entity by "User"
     *
     * @param user
     * @return List of TicketExcursion
     */
    List<TicketExcursion> findAllByUser(User user);
}
