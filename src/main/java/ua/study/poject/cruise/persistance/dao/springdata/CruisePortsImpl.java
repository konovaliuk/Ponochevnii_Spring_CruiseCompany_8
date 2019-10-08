package ua.study.poject.cruise.persistance.dao.springdata;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.study.poject.cruise.persistance.dao.ICruisePorts;
import ua.study.poject.cruise.persistance.entity.CruisePorts;
import ua.study.poject.cruise.persistance.repository.CruisePortsRepository;

import java.util.List;


@Repository
@NoArgsConstructor
public class CruisePortsImpl implements ICruisePorts {

    @Autowired
    CruisePortsRepository cruisePortsRepository;

    @Override
    public CruisePorts save(CruisePorts cruisePorts) {
        return cruisePortsRepository.save(cruisePorts);
    }

    @Override
    public List<CruisePorts> findByCruiseId(Long cruiseId) {
        return cruisePortsRepository.findCruisePortsByCruise_IdOrderByDateIn(cruiseId);
    }
}
