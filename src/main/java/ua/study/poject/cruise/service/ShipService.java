package ua.study.poject.cruise.service;

import org.springframework.beans.factory.annotation.Autowired;

import ua.study.poject.cruise.persistance.entity.Ship;
import ua.study.poject.cruise.persistance.entity.Shipservice;
import ua.study.poject.cruise.persistance.dao.IShip;
import ua.study.poject.cruise.persistance.dao.IShipservice;
import ua.study.poject.cruise.persistance.repository.ShipRepository;

import java.util.List;

@org.springframework.stereotype.Service
public class ShipService {
    @Autowired
    IShip shipImpl;

    @Autowired
    IShipservice shipServiceImpl;

    @Autowired
    ShipRepository shipRepository;


    public String createShip(Ship newShip) {
        if(newShip.getShipName().equals(""))
            return "message.createship.errfailed";
        shipImpl.create(newShip);
        return newShip.getId() == null ? "message.createship.errfailed" : "message.createship.ok";
    }

    public List<Ship> getAllShips() {
        return shipImpl.findAll();
    }

    public List<Shipservice> getAllServicesByShipId(Long id) {
        return shipServiceImpl.getAllServicesByShipId(id);
    }

    public boolean isServicePresentOnThisShip(Long selectedShipId, Long selectedServiceId) {
        return shipServiceImpl.isServicePresentOnThisShip(selectedShipId, selectedServiceId);
    }


    public Ship getShipById(Long id) {
        return shipImpl.findById(id).orElse(null);
    }
}
