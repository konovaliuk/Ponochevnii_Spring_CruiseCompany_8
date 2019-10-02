package ua.study.poject.cruise.persistance.dao.springdata;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.study.poject.cruise.persistance.entity.Cruise;
import ua.study.poject.cruise.persistance.entity.Ship;
import ua.study.poject.cruise.persistance.dao.ICruise;
import ua.study.poject.cruise.persistance.repository.CruiseRepository;

import java.util.List;
import java.util.Optional;

@Repository
@NoArgsConstructor
@AllArgsConstructor
public class CruiseImpl implements ICruise {

    @Autowired
    CruiseRepository cruiseRepository;
    
    @Override
    public Cruise save(Cruise cruise){
        return cruiseRepository.save(cruise);
    }

    @Override
    public List<Cruise> findAll(){
        return cruiseRepository.findAll();
    }

    @Override
    public Optional<Cruise> findById(Long id){
        return cruiseRepository.findById(id);
    }

    @Override
    public List<Cruise> findAllByShip(Ship ship) {
        return cruiseRepository.findAllByShip(ship);
    }

}
