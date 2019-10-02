package ua.study.poject.cruise.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.study.poject.cruise.persistance.entity.TicketclassBonus;

import java.util.List;

public interface TicketclassBonusRepository extends JpaRepository<TicketclassBonus, Long> {
    void deleteByShipService_Id(Long id);

    List<TicketclassBonus> findAllByCruise_IdAndTicketclass_TicketclassName(Long cruiseId, String ticketclassName);

}