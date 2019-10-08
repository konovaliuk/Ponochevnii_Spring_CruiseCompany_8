package ua.study.poject.cruise.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.study.poject.cruise.persistance.dao.ITicketclass;
import ua.study.poject.cruise.persistance.dao.ITicketclassBonus;
import ua.study.poject.cruise.persistance.dao.IUserShip;
import ua.study.poject.cruise.persistance.entity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * the class contains logic for working with Bonus and Manager entities
 */
@Service
public class ManagerAndBonuseService {

    @Autowired
    IUserShip userShipImpl;

    @Autowired
    ITicketclass ticketclassImpl;

    @Autowired
    ITicketclassBonus ticketclassBonusImpl;

    private static final Logger LOGGER = Logger.getLogger(ManagerAndBonuseService.class);

    /**
     * the method finds all the ships on which the Manager is allowed to manage bonuses
     *
     * @param user
     * @return List of UserShip or empty list if the search was unsuccessful
     */
    public List<UserShip> getAllShipsByManager(User user) {
        return new ArrayList<>(userShipImpl.findUserShipsByUser(user));
    }

    /**
     * The method allows you to get a list of all Ticketclass that are in the system
     *
     * @return List of Ticketclass or empty list if the search was unsuccessful
     */
    public List<Ticketclass> getAllTicketclass() {
        return ticketclassImpl.findAll();
    }

    /**
     * The method allows you to get a list of all TicketclassBonus that are available
     * for this ticket class in the selected cruise
     *
     * @param cruiseId
     * @param ticketclassName
     * @return List of TicketclassBonus or empty list if the search was unsuccessful
     */
    public List<TicketclassBonus> getAllBonusesByCruiseIdTicketclassName(Long cruiseId, String ticketclassName) {
        return ticketclassBonusImpl.findAllBonusesByCruiseIdTicketclassName(cruiseId, ticketclassName);
    }

    /**
     * The method saves a bonus for the selected ticket class
     *
     * @param ticketclass
     * @param selectedshipservice
     * @param selectedCruise
     * @return "true" if the operation was successful and "false" if unsuccessful
     */
    public boolean addBonus(Ticketclass ticketclass, Shipservice selectedshipservice, Cruise selectedCruise) {
        TicketclassBonus ticketclassBonus = new TicketclassBonus(ticketclass, selectedshipservice, selectedCruise);
        ticketclassBonusImpl.create(ticketclassBonus);
        return ticketclassBonus.getId() != null;
    }

    /**
     * The method removes all bonuses whose "id" numbers are in the list "ticketclassBonusIdList"
     *
     * @param ticketclassBonusIdList
     */
    public void deleteBonuses(List<Long> ticketclassBonusIdList) {
        ticketclassBonusImpl.deleteAllByListId(ticketclassBonusIdList);
    }
}
