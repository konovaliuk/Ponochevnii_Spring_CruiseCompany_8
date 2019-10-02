package ua.study.poject.cruise.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.study.poject.cruise.persistance.entity.CruisePorts;

import java.util.List;

public interface CruisePortsRepository extends JpaRepository<CruisePorts, Long> {
    List<CruisePorts> findCruisePortsByCruise_IdOrderByDateIn(Long cruiseId);
}
