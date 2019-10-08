package ua.study.poject.cruise.persistance.dao;

import ua.study.poject.cruise.persistance.entity.Role;

import java.util.List;

/**
 * The interface IRole defines an interaction contract with a Role entity
 */
public interface IRole {

    /**
     * This method finds all the Roles
     *
     * @return List of Roles
     */
    List<Role> findAll();

    /**
     * This method finds Role by "Role name"
     *
     * @param roleName
     * @return Role
     */
    Role findByRole(String roleName);

    /**
     * This method allows check if Role exist in system
     *
     * @param role
     * @return true if Role exist
     */
    boolean isRoleExist(Role role);

}
