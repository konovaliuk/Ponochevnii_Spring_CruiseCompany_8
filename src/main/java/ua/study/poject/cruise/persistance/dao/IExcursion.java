package ua.study.poject.cruise.persistance.dao;

import ua.study.poject.cruise.persistance.entity.Excursion;

import java.util.List;
import java.util.Optional;

/**
 * The interface IExcursion defines an interaction contract with a Excursion entity
 */
public interface IExcursion {

    /**
     * The "save" method saves the new Excursion entity, which is passed to it as a parameter.
     *
     * @param excursion new entity that needs to be stored
     * @return updated Excursion object that has a relevant "id"
     */
    Excursion save(Excursion excursion);

    /**
     * This method Excursion by "id"
     *
     * @param id
     * @return Optional of Excursion entity
     */
    Optional<Excursion> findById(Long id);

    /**
     * This method allows to find all excursions in a given port
     *
     * @param portId
     * @return List of Excursion
     */
    List<Excursion> findByPortId(Long portId);
}
