package ua.study.poject.cruise.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.study.poject.cruise.persistance.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String roleName);
}