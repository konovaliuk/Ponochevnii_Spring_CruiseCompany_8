package ua.study.poject.cruise.persistance.dao;

import ua.study.poject.cruise.persistance.entity.User;

import java.util.Optional;

public interface IUser {

    User create(User user);

    Optional<User> findById(Long id);

    User findByLoginAndPassword(String login, String password);

    User update(User user);

    User findByLogin(String login);
}
