package ua.study.poject.cruise.persistance.dao;

import ua.study.poject.cruise.persistance.entity.Cruise;
import ua.study.poject.cruise.persistance.entity.Ship;

import java.util.List;
import java.util.Optional;


public interface ICruise {

    Cruise save(Cruise cruise);

    List<Cruise> findAll();

    Optional<Cruise> findById(Long id);

    List<Cruise> findAllByShip(Ship ship);
}
