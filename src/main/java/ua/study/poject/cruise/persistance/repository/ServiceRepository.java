package ua.study.poject.cruise.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.study.poject.cruise.persistance.entity.Service;

import java.util.Optional;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    Service findByServiceName(String serviceName);

    Optional<Service> findById(Long id);
}