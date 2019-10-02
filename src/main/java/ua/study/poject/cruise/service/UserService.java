package ua.study.poject.cruise.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.study.poject.cruise.persistance.entity.Role;
import ua.study.poject.cruise.persistance.entity.User;
import ua.study.poject.cruise.persistance.dao.IRole;
import ua.study.poject.cruise.persistance.dao.IUser;
import ua.study.poject.cruise.util.PasswordEncryptor;

import java.util.List;

@Service
public class UserService {

    @Autowired
    IUser userImpl;

    @Autowired
    IRole roleImpl;

    private PasswordEncryptor encryptor = new PasswordEncryptor();

    private static final Logger LOGGER = Logger.getLogger(UserService.class);

    // войти
    public User findUserByLoginPassword(String login, String password) {
        return userImpl.findByLoginAndPassword(login, new PasswordEncryptor().encode(password));
    }


    // зарегистрировать нового
    public String addNewUser(User user) {
        if(user.getLogin().equals("") || user.getPassword().equals(""))
            return "message.register.erroremptyfild";


        User user2 = userImpl.findByLogin(user.getLogin());
        if (user2 != null)
            return "message.register.errexist";

        user.setRole(roleImpl.findByRole(Role.ROLE_CUSTOMER));
        user.setPassword(new PasswordEncryptor().encode(user.getPassword()));
        userImpl.create(user);
        return user.getId() == null ? "message.register.errorthereisuser" : "message.register.ok";

    }

    public String changeUserRole(String login, String role){
        User user = userImpl.findByLogin(login);
        if(user == null)
            return "message.changeuserrole.errnouser";

        Role roleFromDB = findRoleByRoleName(role);
        if(roleFromDB == null)
            return "message.changeuserrole.errnorole";

        user.setRole(roleFromDB);
        userImpl.update(user);
        return "message.changeuserrole.ok";
    }

    public String editAccount(User currentuser, User editedUser) { // TODO переделать
        int currentUserHash = currentuser.hashCode();
        if(editedUser.getPassword() != null && !editedUser.getPassword().equals(""))
            currentuser.setPassword(new PasswordEncryptor().encode(editedUser.getPassword()));
        if(editedUser.getFirstName() != null && !editedUser.getFirstName().equals(""))
            currentuser.setFirstName(editedUser.getFirstName());
        if(editedUser.getSecondName() != null && !editedUser.getSecondName().equals(""))
            currentuser.setSecondName(editedUser.getSecondName());
        if(editedUser.getEmail() != null && !editedUser.getEmail().equals(""))
            currentuser.setEmail(editedUser.getEmail());
        if(editedUser.getTel() != null && !editedUser.getTel().equals(""))
            currentuser.setTel(editedUser.getTel());

        userImpl.update(currentuser);
        if(currentUserHash != currentuser.hashCode())
            return "message.editaccount.ok";
        return "message.editaccount.eerupdate";

    }

    public User changeUserRole(User oldUser, User adminUser, Role newRole) {
        if (oldUser == null || oldUser.getId() <= 1 || oldUser.getLogin() == null || oldUser.getPassword() == null)
            return oldUser;

        if (adminUser == null || adminUser.getId() <= 1 || adminUser.getLogin() == null || adminUser.getPassword() == null)
            return oldUser;

        User adminFromDB;

        adminFromDB = userImpl.findByLoginAndPassword(adminUser.getLogin(), adminUser.getPassword());
        if (adminFromDB.getId() < 1)
            return adminUser;

        if (!adminFromDB.getRole().equals(roleImpl.findByRole(Role.ROLE_ADMIN)))
            return adminUser;

        if (!roleImpl.isRoleExist(newRole))
            return adminUser;

        oldUser.setRole(newRole);
        return userImpl.update(oldUser);
    }



//    public User fillFieldsUser(Long id, String login, String password, String firstName, String secondName, String email, String tel, Role role) {
//        User user = new User();
//        user.setId(id);
//        user.setLogin(login);
//        user.setPassword(encryptor.encode(password));
//        user.setFirstName(firstName);
//        user.setSecondName(secondName);
//        user.setEmail(email);
//        user.setTel(tel);
//        user.setRole(role);
//        return user;
//    }

    public Role findRoleByRoleName(String roleName) {
        return roleImpl.findByRole(roleName);
    }

    public List<Role> findAllRoles() {
        return roleImpl.findAll();
    }
}
