package ua.study.poject.cruise.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.study.poject.cruise.persistance.entity.*;
import ua.study.poject.cruise.persistance.dao.ITicketclass;
import ua.study.poject.cruise.persistance.dao.ITicketclassBonus;
import ua.study.poject.cruise.persistance.dao.IUserShip;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerAndBonuseService {

    @Autowired
    IUserShip userShipImpl;

    @Autowired
    ITicketclass ticketclassImpl;

    @Autowired
    ITicketclassBonus ticketclassBonusImpl;

    private static final Logger LOGGER = Logger.getLogger(ManagerAndBonuseService.class);


    public List<UserShip> getAllShipsByManager(User user) {
        return new ArrayList<>(userShipImpl.findUserShipsByUser(user));
    }


    public List<Ticketclass> getAllTicketclass() {
        return ticketclassImpl.findAll();
    }

    public List<TicketclassBonus> getAllBonusesByCruiseIdTicketclassName(Long cruiseId, String ticketclassName) {
        return ticketclassBonusImpl.getAllBonusesByCruiseIdTicketclassName(cruiseId, ticketclassName);
    }

    public int addBonus(Ticketclass ticketclass, Shipservice selectedshipservice, Cruise selectedCruise) {

        TicketclassBonus ticketclassBonus = new TicketclassBonus(ticketclass, selectedshipservice, selectedCruise);
        ticketclassBonusImpl.create(ticketclassBonus);
        if(ticketclassBonus.getId() == null)
            return 0;
        return 1;
    }

    public void deleteBonuses(List<Long> ticketclassBonusIdList) {
        ticketclassBonusImpl.deleteAllByListId(ticketclassBonusIdList);
    }
}
