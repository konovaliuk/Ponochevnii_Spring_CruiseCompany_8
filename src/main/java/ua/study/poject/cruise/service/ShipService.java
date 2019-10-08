package ua.study.poject.cruise.service;

import org.springframework.beans.factory.annotation.Autowired;
import ua.study.poject.cruise.persistance.dao.IShip;
import ua.study.poject.cruise.persistance.dao.IShipservice;
import ua.study.poject.cruise.persistance.entity.Ship;
import ua.study.poject.cruise.persistance.entity.Shipservice;
import ua.study.poject.cruise.persistance.repository.ShipRepository;

import java.util.List;

/**
 * The class implements all the necessary logic for working with the Ship entity
 */
@org.springframework.stereotype.Service
public class ShipService {
    @Autowired
    IShip shipImpl;

    @Autowired
    IShipservice shipServiceImpl;

    @Autowired
    ShipRepository shipRepository;


    /**
     * This method create new Ship
     *
     * @param newShip
     * @return Message for user
     */
    public String createShip(Ship newShip) {
        if (newShip.getShipName().equals("")) {
            return "message.createship.errfailed";
        }
        shipImpl.create(newShip);
        return newShip.getId() == null ? "message.createship.errfailed" : "message.createship.ok";
    }

    /**
     * The method returns all the ships that are in the system
     *
     * @return List of Ship or empty list if the search was unsuccessful
     */
    public List<Ship> getAllShips() {
        return shipImpl.findAll();
    }

    /**
     * The method returns all the PrintableServiceOnShip by "Ship id"
     *
     * @param id "Ship id"
     * @return List of Shipservice or empty list if the search was unsuccessful
     */
    public List<Shipservice> getAllServicesByShipId(Long id) {
        return shipServiceImpl.findAllServicesByShipId(id);
    }

    /**
     * The method checks if this service is present on the selected ship
     *
     * @param selectedShipId
     * @param selectedServiceId
     * @return if the Service present on this Ship
     */
    public boolean isServicePresentOnThisShip(Long selectedShipId, Long selectedServiceId) {
        return shipServiceImpl.isServicePresentOnThisShip(selectedShipId, selectedServiceId);
    }

    /**
     * Finds Ship by id
     *
     * @param id "Ship id"
     * @return Ship or null if the search failed
     */
    public Ship getShipById(Long id) {
        return shipImpl.findById(id).orElse(null);
    }
}
