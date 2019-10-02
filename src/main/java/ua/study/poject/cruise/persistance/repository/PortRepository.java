package ua.study.poject.cruise.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.study.poject.cruise.persistance.entity.Port;

public interface PortRepository extends JpaRepository<Port, Long> {
}