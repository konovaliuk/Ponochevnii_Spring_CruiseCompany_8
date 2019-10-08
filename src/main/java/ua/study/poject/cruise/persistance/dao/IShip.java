package ua.study.poject.cruise.persistance.dao;

import ua.study.poject.cruise.persistance.entity.Ship;

import java.util.List;
import java.util.Optional;

/**
 * The interface IShip defines an interaction contract with a Ship entity
 */
public interface IShip {

    /**
     * The create method saves the new Ship entity, which is passed to it as a parameter
     *
     * @param ship new entity that needs to be stored
     * @return updated Ship object that has a relevant "id"
     */
    Ship create(Ship ship);

    /**
     * This method allow find all the Ships that are presented in the system
     *
     * @return List of Ships
     */
    List<Ship> findAll();

    /**
     * Finds Ship by id
     *
     * @param id
     * @return Optional of Ship
     */
    Optional<Ship> findById(Long id);
}
