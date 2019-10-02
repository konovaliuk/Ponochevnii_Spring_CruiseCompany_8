package ua.study.poject.cruise.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.study.poject.cruise.persistance.entity.TicketExcursion;
import ua.study.poject.cruise.persistance.entity.User;

import java.util.List;

public interface TicketExcursionRepository extends JpaRepository<TicketExcursion, Long> {

    List<TicketExcursion> findAllByUser(User user);
}