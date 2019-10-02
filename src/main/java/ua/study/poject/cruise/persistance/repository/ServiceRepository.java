package ua.study.poject.cruise.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.study.poject.cruise.persistance.entity.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    Service findByServiceName(String serviceName);
}