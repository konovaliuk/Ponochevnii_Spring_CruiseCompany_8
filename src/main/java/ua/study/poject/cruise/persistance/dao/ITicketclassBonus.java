package ua.study.poject.cruise.persistance.dao;

import ua.study.poject.cruise.persistance.entity.TicketclassBonus;

import java.util.List;

/**
 * The interface ITicketclassBonus defines an interaction contract with a TicketclassBonus entity
 */
public interface ITicketclassBonus {

    /**
     * The create method saves the new TicketclassBonus entity, which is passed to it as a parameter
     *
     * @param ticketclassBonus
     * @return updated TicketclassBonus object that has a relevant "id"
     */
    TicketclassBonus create(TicketclassBonus ticketclassBonus);

    /**
     * This method removes all TicketclassBonuse records by "Shipservice id"
     *
     * @param id
     */
    void deleteByShipserviceId(Long id);

    /**
     * This method removes TicketclassBonuse record by List of "id"
     *
     * @param listId
     */
    void deleteAllByListId(List<Long> listId);

    /**
     * Finds all bonuses by "Cruise id" and "Ticketclass name"
     *
     * @param cruiseId
     * @param ticketclassName
     * @return List of TicketclassBonuses
     */
    List<TicketclassBonus> findAllBonusesByCruiseIdTicketclassName(Long cruiseId, String ticketclassName);
}
