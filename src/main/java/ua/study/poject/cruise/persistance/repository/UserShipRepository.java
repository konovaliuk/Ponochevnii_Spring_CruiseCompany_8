package ua.study.poject.cruise.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.study.poject.cruise.persistance.entity.User;
import ua.study.poject.cruise.persistance.entity.UserShip;

import java.util.Set;

public interface UserShipRepository extends JpaRepository<UserShip, Long> {
    Set<UserShip> findUserShipsByUser(User user);


}