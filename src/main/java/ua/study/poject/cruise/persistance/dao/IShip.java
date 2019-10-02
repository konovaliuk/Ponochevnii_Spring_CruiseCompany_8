package ua.study.poject.cruise.persistance.dao;

import ua.study.poject.cruise.persistance.entity.Ship;

import java.util.List;
import java.util.Optional;

public interface IShip {

    Ship create(Ship ship);

    List<Ship> findAll();

    Optional<Ship> findById(Long id);
}
