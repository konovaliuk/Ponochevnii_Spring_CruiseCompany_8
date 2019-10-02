package ua.study.poject.cruise.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.study.poject.cruise.persistance.entity.Cruise;
import ua.study.poject.cruise.persistance.entity.Ship;

import java.util.List;

public interface CruiseRepository extends JpaRepository<Cruise, Long> {
    List<Cruise> findAll();

    List<Cruise> findAllByShip(Ship ship);

//    List<Cruise> findAllByShip_Id(Long shipId);
}
