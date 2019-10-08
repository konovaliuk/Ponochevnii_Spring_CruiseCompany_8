package ua.study.poject.cruise.persistance.dao;

import ua.study.poject.cruise.persistance.entity.Service;

import java.util.List;
import java.util.Optional;

/**
 * The interface IService defines an interaction contract with a Service entity
 */
public interface IService {

    /**
     * The create method saves the new Service entity, which is passed to it as a parameter
     *
     * @param service new entity that needs to be stored
     * @return updated Service object that has a relevant "id"
     */
    Service create(Service service);

    /**
     * This method allows find all the Services that are presented in the system
     *
     * @return List of Service
     */
    List<Service> findAll();

    /**
     * This method allows find the Services by "id"
     *
     * @param id
     * @return Optional of Service
     */
    Optional<Service> findById(Long id);

    /**
     * This method allows find the Services by "service name"
     *
     * @param serviceName
     * @return Service
     */
    Service findByName(String serviceName);
}
