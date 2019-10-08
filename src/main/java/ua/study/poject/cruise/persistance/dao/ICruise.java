package ua.study.poject.cruise.persistance.dao;

import ua.study.poject.cruise.persistance.entity.Cruise;
import ua.study.poject.cruise.persistance.entity.Ship;

import java.util.List;
import java.util.Optional;

/**
 * The interface ICruise defines an interaction contract with a Cruise entity
 */
public interface ICruise {

    /**
     * The "save" method saves the new Cruise entity, which is passed to it as a parameter.
     *
     * @param cruise new entity that needs to be stored
     * @return updated Cruise object that has a relevant "id"
     */
    Cruise save(Cruise cruise);

    /**
     * The method findAll returns all the Cruises
     *
     * @return List of Cruises
     */
    List<Cruise> findAll();

    /**
     * The method findById returns a Optional of Cruise entity whose number is "id"
     *
     * @param id number of crusie
     * @return Optional of Cruise entity
     */
    Optional<Cruise> findById(Long id);

    /**
     * The method findAllByShip allows find all Cruises that the ship is sailing on
     *
     * @param ship
     * @return List of Cruises
     */
    List<Cruise> findAllByShip(Ship ship);
}
