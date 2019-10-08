package ua.study.poject.cruise.persistance.dao;

import ua.study.poject.cruise.persistance.entity.Ship;
import ua.study.poject.cruise.persistance.entity.User;
import ua.study.poject.cruise.persistance.entity.UserShip;

import java.util.Set;

/**
 * The interface IUserShip defines an interaction contract with a UserShip entity
 */
public interface IUserShip {

    /**
     * The create method saves the new UserShip entity, which is determined by the parameters "Ship id" and "User id"
     *
     * @param ship
     * @param user
     * @return new UserShip entity
     */
    UserShip create(Ship ship, User user);

    /**
     * The method findUserShipsByUser returns all the Ships by "User"
     *
     * @param user
     * @return Set of UserShip
     */
    Set<UserShip> findUserShipsByUser(User user);
}
