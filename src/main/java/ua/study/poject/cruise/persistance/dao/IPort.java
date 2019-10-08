package ua.study.poject.cruise.persistance.dao;

import ua.study.poject.cruise.persistance.entity.Port;

import java.util.List;
import java.util.Optional;

/**
 * The interface IPort defines an interaction contract with a Port entity
 */
public interface IPort {

    /**
     * The "save" method saves the new Port entity, which is passed to it as a parameter
     *
     * @param port new entity that needs to be stored
     * @return updated Port object that has a relevant "id"
     */
    Port save(Port port);

    /**
     * The method findAll returns all the Ports
     *
     * @return List of Ports
     */
    List<Port> findAll();

    /**
     * The method findById returns an Optional of Port entity whose number is "id"
     *
     * @param id
     * @return Optional of Port entity
     */
    Optional<Port> findById(Long id);
}
