package ua.study.poject.cruise.persistance.dao.springdata;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.study.poject.cruise.persistance.entity.User;
import ua.study.poject.cruise.persistance.dao.IUser;
import ua.study.poject.cruise.persistance.repository.UserRepository;

import java.util.Optional;

@Repository
@NoArgsConstructor
@AllArgsConstructor
public class UserImpl implements IUser {

    @Autowired
    UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
