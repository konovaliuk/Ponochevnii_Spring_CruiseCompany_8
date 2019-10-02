package ua.study.poject.cruise.persistance.dao;

import ua.study.poject.cruise.persistance.entity.TicketclassBonus;

import java.util.List;

public interface IPrintableTicketclassBonus {

//    List<PrintableTicketclassBonus> getAllBonusesByCruiseIdTicketclassId (Long cruiseId, Long ticketclassId);

    List<TicketclassBonus> getAllBonusesByCruiseIdTicketclassName(Long cruiseId, String ticketclassName);
}
