package ua.study.poject.cruise.persistance.dao;

import ua.study.poject.cruise.persistance.entity.Ticketclass;

import java.util.List;

/**
 * The interface ITicketclass defines an interaction contract with a Ticketclass entity
 */
public interface ITicketclass {

    /**
     * Finds all the Ticket classes
     *
     * @return List of Ticketclass
     */
    List<Ticketclass> findAll();
}
