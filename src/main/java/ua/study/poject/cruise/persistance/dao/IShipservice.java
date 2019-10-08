package ua.study.poject.cruise.persistance.dao;

import ua.study.poject.cruise.persistance.entity.Shipservice;

import java.util.List;

/**
 * The interface IShipservice defines an interaction contract with a Shipservice entity
 */
public interface IShipservice {

    /**
     * The create method saves the new Shipservice entity, which is passed to it as a parameter
     *
     * @param shipService new entity that needs to be stored
     * @return updated Shipservice object that has a relevant "id"
     */
    Shipservice create(Shipservice shipService);

    /**
     * This method checks if service is present on this ship
     *
     * @param selectedShipId
     * @param selectedServiceId
     * @return true if Service present on this Ship
     */
    boolean isServicePresentOnThisShip(Long selectedShipId, Long selectedServiceId);

    /**
     * This method removes service from the ship
     *
     * @param shipId
     * @param serviceId
     */
    void deleteByShipIdServiceId(Long shipId, Long serviceId);

    /**
     * Finds all Shipservices by "Ship id" and "Service id"
     *
     * @param shipId
     * @param serviceId
     * @return List of Shipservices
     */
    List<Shipservice> findAllByShipIdServiceId(Long shipId, Long serviceId);


    /**
     * Finds all Shipservices by "Ship id"
     *
     * @param id
     * @return List of Shipservices
     */
    List<Shipservice> findAllServicesByShipId(Long id);
}
