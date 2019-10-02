package ua.study.poject.cruise.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.study.poject.cruise.persistance.entity.Excursion;

import java.util.List;

public interface ExcursionRepository extends JpaRepository<Excursion, Long> {
    List<Excursion> findByPort_Id(Long portId);

    Excursion findExcursionByExcursionName(String excursionName);
}