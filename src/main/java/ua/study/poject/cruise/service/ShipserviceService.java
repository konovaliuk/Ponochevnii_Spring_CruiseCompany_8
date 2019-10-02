package ua.study.poject.cruise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.study.poject.cruise.persistance.entity.Service;
import ua.study.poject.cruise.persistance.entity.Ship;
import ua.study.poject.cruise.persistance.entity.Shipservice;
import ua.study.poject.cruise.persistance.dao.IService;
import ua.study.poject.cruise.persistance.dao.IShipservice;
import ua.study.poject.cruise.persistance.dao.ITicketclassBonus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ShipserviceService {

    @Autowired
    IService serviceImpl;

    @Autowired
    IShipservice shipserviceImpl;

    @Autowired
    ITicketclassBonus ticketclassBonusImpl;

    public List<Service> getAllServisesInSystem() {
        return serviceImpl.findAll();
    }

    public String addNewServiceToSystem(Service newService) {
        if(newService.getServiceName() == null || newService.getServiceName().equals(""))
            return "message.addshipservicestosystem.faildtocreate";

        String message;
        if(serviceImpl.findByName(newService.getServiceName()) != null){
            message = "message.addshipservicestosystem.servicealreadyexist";
        } else {
            serviceImpl.create(newService);
            if (newService.getId() == null)
                message = "message.addshipservicestosystem.faildtocreate";
            else
                message = "message.addshipservicestosystem.creationok";
        }

        return message;
    }


    @Transactional
    public void deleteServicesFromShip(Long shipId, List<Long> listServiceId) {

        // если сервис, который надо удалить был добавлен в TicketclassBonus, то надо эту запись удалить в первую очередь. Для этого найдем все ship_service_id
        List<Long> listShipserviceId = new ArrayList<>();
        for (Long aLong : listServiceId) {
            List<Shipservice> allShipservices = shipserviceImpl.findAllIdByShipIdServiceId(shipId, aLong);
            for(Shipservice shipservice : allShipservices){
                listShipserviceId.add(shipservice.getId());
            }
        }

        // Теперь надо удалить TicketclassBonus, by ship_service_id
        for (Long tempId : listShipserviceId)
            ticketclassBonusImpl.deleteByShipserviceId(tempId);

        // потом удаляем services c заданного корабля
        for (Long tempId : listServiceId)
            shipserviceImpl.deleteByShipIdServiceId(shipId, tempId);
    }


    public String addServiceToShip(Long selectedservice, Long selectedship, Integer payable) {
        Optional<Service> serviceOptional =  serviceImpl.findById(selectedservice);
        if (!serviceOptional.isPresent())
            return "message.addshipservicetoship.errorservicenotfound";

        if (shipserviceImpl.isServicePresentOnThisShip(selectedship, serviceOptional.get().getId()))
            return "message.addshipservicetoship.errorserviceduplicate";


        Shipservice newShipservice = addNewServiceToShip(selectedship, payable, serviceOptional.get());
        if(newShipservice.getId() == null)
            return "message.addshipservicetoship.errorservicefaild";
        return "message.addshipservicetoship.serviceadded";
    }

    private Shipservice addNewServiceToShip(Long shipId, Integer payable, Service service) {
        Ship ship = new Ship();
        ship.setId(shipId);
        Shipservice newShipService = new Shipservice(ship, service, payable);
        return shipserviceImpl.create(newShipService);
    }
}
