package ua.study.poject.cruise.persistance.dao;

import ua.study.poject.cruise.persistance.entity.TicketclassBonus;

import java.util.List;

public interface ITicketclassBonus {

    TicketclassBonus create(TicketclassBonus ticketclassBonus);

    void deleteByShipserviceId(Long id);

    void deleteById(Long id);

    void deleteAllByListId(List<Long> listId);

    List<TicketclassBonus> getAllBonusesByCruiseIdTicketclassName(Long cruiseId, String ticketclassName);
}
