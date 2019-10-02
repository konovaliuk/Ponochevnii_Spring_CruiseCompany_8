package ua.study.poject.cruise.persistance.dao;

import ua.study.poject.cruise.persistance.entity.Port;

import java.util.List;
import java.util.Optional;

public interface IPort {

    Port save(Port port);

    List<Port> findAll();

    Optional<Port> findById(Long id);
}
