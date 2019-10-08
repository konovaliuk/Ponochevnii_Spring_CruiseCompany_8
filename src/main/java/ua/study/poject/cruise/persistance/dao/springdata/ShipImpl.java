package ua.study.poject.cruise.persistance.dao.springdata;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.study.poject.cruise.persistance.dao.IShip;
import ua.study.poject.cruise.persistance.entity.Ship;
import ua.study.poject.cruise.persistance.repository.ShipRepository;

import java.util.List;
import java.util.Optional;

@Repository
@NoArgsConstructor
public class ShipImpl implements IShip {

    @Autowired
    ShipRepository shipRepository;

    @Override
    public Ship create(Ship ship) {
        return shipRepository.save(ship);
    }

    @Override
    public List<Ship> findAll() {
        return shipRepository.findAll();
    }

    @Override
    public Optional<Ship> findById(Long id) {
        return shipRepository.findById(id);
    }
}
