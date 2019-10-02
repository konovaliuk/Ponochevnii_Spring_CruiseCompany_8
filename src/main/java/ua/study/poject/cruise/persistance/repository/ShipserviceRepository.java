package ua.study.poject.cruise.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.study.poject.cruise.persistance.entity.Shipservice;

import java.util.List;

public interface ShipserviceRepository extends JpaRepository<Shipservice, Long> {

    void deleteAllByShip_IdAndService_Id(Long shipId, Long serviceId);

    List<Shipservice> findByShip_IdAndService_Id(Long shipId, Long serviceId);

    List<Shipservice> findAllByShip_Id(Long id);
}