package ua.study.poject.cruise.persistance.dao;

import ua.study.poject.cruise.persistance.entity.Excursion;

import java.util.List;
import java.util.Optional;

public interface IExcursion {

    Excursion save(Excursion excursion);

    Optional<Excursion> findById(Long id);

    List<Excursion> findByPortId(Long portId);

//    Excursion findByExcursionName(String excursionName);
}
