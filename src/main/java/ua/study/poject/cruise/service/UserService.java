package ua.study.poject.cruise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.study.poject.cruise.persistance.dao.IRole;
import ua.study.poject.cruise.persistance.dao.IUser;
import ua.study.poject.cruise.persistance.entity.Role;
import ua.study.poject.cruise.persistance.entity.User;
import ua.study.poject.cruise.util.PasswordEncryptor;

import java.util.List;

@Service
public class UserService {

    @Autowired
    IUser userImpl;

    @Autowired
    IRole roleImpl;

    /**
     * The method finds the user by login and password
     *
     * @param login
     * @param password
     * @return User or null if the search failed
     */
    public User findUserByLoginPassword(String login, String password) {
        return userImpl.findByLoginAndPassword(login, new PasswordEncryptor().encode(password));
    }


    /**
     * The method adds (registers) a new user to the system
     *
     * @param user
     * @return message for user
     */
    public String addNewUser(User user) {
        if (user.getLogin().equals("") || user.getPassword().equals("")) {
            return "message.register.erroremptyfild";
        }
        User user2 = userImpl.findByLogin(user.getLogin());
        if (user2 != null) {
            return "message.register.errexist";
        }
        user.setRole(roleImpl.findByRole(Role.ROLE_CUSTOMER));
        user.setPassword(new PasswordEncryptor().encode(user.getPassword()));
        userImpl.create(user);
        return user.getId() == null ? "message.register.errorthereisuser" : "message.register.ok";
    }

    /**
     * The method allows the Admin to change the role of the selected User
     *
     * @param login
     * @param role
     * @return message for user
     */
    public String changeUserRole(String login, String role) {
        User user = userImpl.findByLogin(login);
        if (user == null) {
            return "message.changeuserrole.errnouser";
        }
        Role roleFromDB = findRoleByRoleName(role);
        if (roleFromDB == null) {
            return "message.changeuserrole.errnorole";
        }
        user.setRole(roleFromDB);
        userImpl.update(user);
        return "message.changeuserrole.ok";
    }

    /**
     * The method edits the user account. Old User and New User is the same user,
     * but in New User some fields are changed.
     * This method updates User to the New User state.
     * Login field cannot be changed
     *
     * @param currentuser
     * @param editedUser
     * @return message for user
     */
    public String editAccount(User currentuser, User editedUser) { // TODO переделать
        int currentUserHash = currentuser.hashCode();
        if (editedUser.getPassword() != null && !editedUser.getPassword().equals("")) {
            currentuser.setPassword(new PasswordEncryptor().encode(editedUser.getPassword()));
        }
        if (editedUser.getFirstName() != null && !editedUser.getFirstName().equals("")) {
            currentuser.setFirstName(editedUser.getFirstName());
        }
        if (editedUser.getSecondName() != null && !editedUser.getSecondName().equals("")) {
            currentuser.setSecondName(editedUser.getSecondName());
        }
        if (editedUser.getEmail() != null && !editedUser.getEmail().equals("")) {
            currentuser.setEmail(editedUser.getEmail());
        }
        if (editedUser.getTel() != null && !editedUser.getTel().equals("")) {
            currentuser.setTel(editedUser.getTel());
        }

        userImpl.update(currentuser);
        if (currentUserHash != currentuser.hashCode()) {
            return "message.editaccount.ok";
        }
        return "message.editaccount.eerupdate";

    }

    /**
     * Finds Role by "Role name"
     *
     * @param roleName
     * @return Role or null if the search was unsuccessful
     */
    public Role findRoleByRoleName(String roleName) {
        return roleImpl.findByRole(roleName);
    }

    /**
     * Finds all the roles in system
     *
     * @return List of Roles or an empty list if the search was unsuccessful
     */
    public List<Role> findAllRoles() {
        return roleImpl.findAll();
    }
}
