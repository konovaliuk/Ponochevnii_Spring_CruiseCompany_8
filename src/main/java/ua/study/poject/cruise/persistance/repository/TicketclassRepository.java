package ua.study.poject.cruise.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.study.poject.cruise.persistance.entity.Ticketclass;

public interface TicketclassRepository extends JpaRepository<Ticketclass, Long> {
}