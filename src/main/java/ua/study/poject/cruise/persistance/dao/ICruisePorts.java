package ua.study.poject.cruise.persistance.dao;

import ua.study.poject.cruise.persistance.entity.CruisePorts;

import java.util.List;

/**
 * The interface ICruisePorts defines an interaction contract with a CruisePorts entity
 */
public interface ICruisePorts {

    /**
     * The "save" method saves the new CruisePorts entity, which is passed to it as a parameter.
     *
     * @param cruisePorts new entity that needs to be stored
     * @return updated CruisePorts object that has a relevant "id"
     */
    CruisePorts save(CruisePorts cruisePorts);

    /**
     * The method find all CruisePorts entity by "Cruie id"
     *
     * @param cruiseId
     * @return
     */
    List<CruisePorts> findByCruiseId(Long cruiseId);
}
