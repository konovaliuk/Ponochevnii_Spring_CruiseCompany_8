package ua.study.poject.cruise.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.study.poject.cruise.persistance.entity.Ticket;
import ua.study.poject.cruise.persistance.entity.User;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByUser(User user);
}