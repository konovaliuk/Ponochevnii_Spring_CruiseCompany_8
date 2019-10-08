package ua.study.poject.cruise.persistance.dao;

import ua.study.poject.cruise.persistance.entity.Ticket;
import ua.study.poject.cruise.persistance.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * The interface ITicket defines an interaction contract with a Ticket entity
 */
public interface ITicket {

    /**
     * The create method saves the new Ticket entity, which is passed to it as a parameter
     *
     * @param ticket new entity that needs to be stored
     * @return updated Ticket object that has a relevant "id"
     */
    Ticket create(Ticket ticket);

    /**
     * Finds all tickets
     *
     * @return List of Ticket
     */
    List<Ticket> findAll();

    /**
     * Finds Ticket by "id"
     *
     * @param id
     * @return Optional of Ticket
     */
    Optional<Ticket> findById(Long id);

    /**
     * Finds all Tickets by User
     *
     * @param user
     * @return List of Tickets
     */
    List<Ticket> findTicketByUser(User user);
}
