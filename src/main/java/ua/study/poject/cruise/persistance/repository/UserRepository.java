package ua.study.poject.cruise.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.study.poject.cruise.persistance.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLoginAndPassword(String login, String password);

    User findByLogin(String login);

}