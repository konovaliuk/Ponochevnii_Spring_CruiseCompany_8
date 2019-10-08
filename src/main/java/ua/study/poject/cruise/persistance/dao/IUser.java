package ua.study.poject.cruise.persistance.dao;

import ua.study.poject.cruise.persistance.entity.User;

import java.util.Optional;

/**
 * The interface IUser defines an interaction contract with a User entity
 */
public interface IUser {

    /**
     * The create method saves the new User entity, which is passed to it as a parameter
     *
     * @param user
     * @return updated User object that has a relevant "id"
     */
    User create(User user);

    /**
     * This method finds User by "id"
     *
     * @param id
     * @return Optional of User
     */
    Optional<User> findById(Long id);

    /**
     * This method finds user by login and password
     *
     * @param login
     * @param password
     * @return User entity
     */
    User findByLoginAndPassword(String login, String password);

    /**
     * Updates existing account
     *
     * @param user
     * @return
     */
    User update(User user);

    /**
     * This method finds User by login
     *
     * @param login
     * @return User entity
     */
    User findByLogin(String login);
}
