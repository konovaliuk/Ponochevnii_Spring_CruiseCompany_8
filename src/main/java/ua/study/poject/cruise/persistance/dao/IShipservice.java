package ua.study.poject.cruise.persistance.dao;

import ua.study.poject.cruise.persistance.entity.Shipservice;

import java.util.List;

public interface IShipservice {

    Shipservice create(Shipservice shipService);

    boolean isServicePresentOnThisShip(Long selectedShipId, Long selectedServiceId);

    void deleteByShipIdServiceId(Long shipId, Long serviceId);

    List<Shipservice> findAllIdByShipIdServiceId(Long shipId, Long serviceId);


    List<Shipservice> getAllServicesByShipId(Long id);
}
