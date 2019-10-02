package ua.study.poject.cruise.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.study.poject.cruise.persistance.entity.Ship;

public interface ShipRepository extends JpaRepository<Ship, Long> {
}