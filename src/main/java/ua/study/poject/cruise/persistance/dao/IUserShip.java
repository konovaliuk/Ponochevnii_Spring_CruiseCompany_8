package ua.study.poject.cruise.persistance.dao;

import ua.study.poject.cruise.persistance.entity.Ship;
import ua.study.poject.cruise.persistance.entity.User;
import ua.study.poject.cruise.persistance.entity.UserShip;

import java.util.Set;

public interface IUserShip {

    UserShip create(Ship ship, User user);

    Set<UserShip> findUserShipsByUser(User user);
}
