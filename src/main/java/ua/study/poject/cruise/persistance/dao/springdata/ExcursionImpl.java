package ua.study.poject.cruise.persistance.dao.springdata;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.study.poject.cruise.persistance.dao.IExcursion;
import ua.study.poject.cruise.persistance.entity.Excursion;
import ua.study.poject.cruise.persistance.repository.ExcursionRepository;

import java.util.List;
import java.util.Optional;

@Repository
@NoArgsConstructor
public class ExcursionImpl implements IExcursion {

    @Autowired
    ExcursionRepository excursionRepository;

    @Override
    public Excursion save(Excursion excursion) {
        return excursionRepository.save(excursion);
    }

    @Override
    public Optional<Excursion> findById(Long id) {
        return excursionRepository.findById(id);
    }

    @Override
    public List<Excursion> findByPortId(Long portId) {
        return excursionRepository.findByPort_Id(portId);
    }

}
