package ua.study.poject.cruise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.study.poject.cruise.persistance.dao.IService;
import ua.study.poject.cruise.persistance.dao.IShipservice;
import ua.study.poject.cruise.persistance.dao.ITicketclassBonus;
import ua.study.poject.cruise.persistance.entity.Service;
import ua.study.poject.cruise.persistance.entity.Ship;
import ua.study.poject.cruise.persistance.entity.Shipservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The class implements all the necessary logic for working with the Shipservice and Service entities
 */
@Component
public class ShipserviceService {

    @Autowired
    IService serviceImpl;

    @Autowired
    IShipservice shipserviceImpl;

    @Autowired
    ITicketclassBonus ticketclassBonusImpl;

    /**
     * The method finds all services in the system
     *
     * @return List of Service or empty list if the search was unsuccessful
     */
    public List<Service> getAllServisesInSystem() {
        return serviceImpl.findAll();
    }

    /**
     * The method adds new Service in the system
     *
     * @param newService
     * @return Message for user
     */
    public String addNewServiceToSystem(Service newService) {
        if (newService.getServiceName() == null || newService.getServiceName().equals("")) {
            return "message.addshipservicestosystem.faildtocreate";
        }

        String message;
        if (serviceImpl.findByName(newService.getServiceName()) != null) {
            message = "message.addshipservicestosystem.servicealreadyexist";
        } else {
            serviceImpl.create(newService);
            if (newService.getId() == null) {
                message = "message.addshipservicestosystem.faildtocreate";
            } else {
                message = "message.addshipservicestosystem.creationok";
            }
        }

        return message;
    }


    /**
     * Method removes a service from the Ship
     *
     * @param shipId        selected Ship
     * @param listServiceId List of "Services id"
     */
    @Transactional
    public void deleteServicesFromShip(Long shipId, List<Long> listServiceId) {

        /* if the service to be deleted has been added to TicketclassBonus,
               then this record must be deleted first. To do this, find all ship_service_id */
        List<Long> listShipserviceId = new ArrayList<>();
        for (Long aLong : listServiceId) {
            List<Shipservice> allShipservices = shipserviceImpl.findAllByShipIdServiceId(shipId, aLong);
            for (Shipservice shipservice : allShipservices) {
                listShipserviceId.add(shipservice.getId());
            }
        }

        /* Now we need to remove TicketclassBonus, by ship_service_id */
        for (Long tempId : listShipserviceId) {
            ticketclassBonusImpl.deleteByShipserviceId(tempId);
        }

        /* then we remove services from the given ship */
        for (Long tempId : listServiceId) {
            shipserviceImpl.deleteByShipIdServiceId(shipId, tempId);
        }
    }


    /**
     * The method adds new Service to ship
     *
     * @param selectedservice
     * @param selectedship
     * @param payable
     * @return Message for user
     */
    public String addServiceToShip(Long selectedservice, Long selectedship, Integer payable) {
        Optional<Service> serviceOptional = serviceImpl.findById(selectedservice);
        if (!serviceOptional.isPresent()) {
            return "message.addshipservicetoship.errorservicenotfound";
        }

        if (shipserviceImpl.isServicePresentOnThisShip(selectedship, serviceOptional.get().getId())) {
            return "message.addshipservicetoship.errorserviceduplicate";
        }


        Shipservice newShipservice = addNewServiceToShip(selectedship, payable, serviceOptional.get());
        if (newShipservice.getId() == null) {
            return "message.addshipservicetoship.errorservicefaild";
        }
        return "message.addshipservicetoship.serviceadded";
    }


    private Shipservice addNewServiceToShip(Long shipId, Integer payable, Service service) {
        Ship ship = new Ship();
        ship.setId(shipId);
        Shipservice newShipService = new Shipservice(ship, service, payable);
        return shipserviceImpl.create(newShipService);
    }
}
