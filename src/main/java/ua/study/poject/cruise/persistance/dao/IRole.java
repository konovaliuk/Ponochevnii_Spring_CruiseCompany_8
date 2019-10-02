package ua.study.poject.cruise.persistance.dao;

import ua.study.poject.cruise.persistance.entity.Role;

import java.util.List;

public interface IRole {

    List<Role> findAll();

    Role findByRole(String roleName);

    boolean isRoleExist(Role role);

}
