package ua.study.poject.cruise.persistance.dao;

import ua.study.poject.cruise.persistance.entity.Service;

import java.util.List;
import java.util.Optional;

public interface IService {

    Service create(Service service);

    List<Service> findAll();

    Optional<Service> findById(Long id);

    Service findByName(String serviceName);
}
