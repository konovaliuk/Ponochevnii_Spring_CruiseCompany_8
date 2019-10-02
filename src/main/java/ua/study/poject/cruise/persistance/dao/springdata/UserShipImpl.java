package ua.study.poject.cruise.persistance.dao.springdata;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.study.poject.cruise.persistance.entity.Ship;
import ua.study.poject.cruise.persistance.entity.User;
import ua.study.poject.cruise.persistance.entity.UserShip;
import ua.study.poject.cruise.persistance.dao.IUserShip;
import ua.study.poject.cruise.persistance.repository.ShipRepository;
import ua.study.poject.cruise.persistance.repository.UserShipRepository;

import java.util.Set;

@Repository
@NoArgsConstructor
@AllArgsConstructor
public class UserShipImpl implements IUserShip {

    @Autowired
    UserShipRepository userShipRepository;
    @Autowired
    ShipRepository shipRepository;

    @Override
    public UserShip create(Ship ship, User user) {
        UserShip userShip = new UserShip(ship, user);
        return userShipRepository.save(userShip);
    }

    @Override
    public Set<UserShip> findUserShipsByUser(User user) {
        return userShipRepository.findUserShipsByUser(user);
    }
}
