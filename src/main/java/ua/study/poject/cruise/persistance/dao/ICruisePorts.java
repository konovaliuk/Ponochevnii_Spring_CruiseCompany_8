package ua.study.poject.cruise.persistance.dao;

import ua.study.poject.cruise.persistance.entity.CruisePorts;

import java.util.List;

public interface ICruisePorts {

    CruisePorts save(CruisePorts cruisePorts);

    List<CruisePorts> findByCruiseId(Long cruiseId);

    void delete(CruisePorts cruisePorts);
}
