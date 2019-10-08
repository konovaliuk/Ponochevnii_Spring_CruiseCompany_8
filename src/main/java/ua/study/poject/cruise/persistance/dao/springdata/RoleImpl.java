package ua.study.poject.cruise.persistance.dao.springdata;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.study.poject.cruise.persistance.dao.IRole;
import ua.study.poject.cruise.persistance.entity.Role;
import ua.study.poject.cruise.persistance.repository.RoleRepository;

import java.util.List;

@Repository
@NoArgsConstructor
public class RoleImpl implements IRole {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findByRole(String roleName) {
        return roleRepository.findByRole(roleName);
    }

    @Override
    public boolean isRoleExist(Role role) {
        return roleRepository.existsById(role.getId());
    }
}
