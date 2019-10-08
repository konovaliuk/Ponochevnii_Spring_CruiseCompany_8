package ua.study.poject.cruise.persistance.dao.springdata;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.study.poject.cruise.persistance.dao.IShipservice;
import ua.study.poject.cruise.persistance.entity.Shipservice;
import ua.study.poject.cruise.persistance.repository.ShipserviceRepository;

import java.util.List;

@Repository
@NoArgsConstructor
public class ShipserviceImpl implements IShipservice {

    @Autowired
    ShipserviceRepository shipserviceRepository;

    @Override
    public Shipservice create(Shipservice shipService) {
        return shipserviceRepository.save(shipService);
    }

    @Override
    public boolean isServicePresentOnThisShip(Long selectedShipId, Long selectedServiceId) {
        List<Shipservice> listLong = shipserviceRepository.findByShip_IdAndService_Id(selectedShipId, selectedServiceId);
        return listLong != null && listLong.size() != 0;
    }

    @Override
    public void deleteByShipIdServiceId(Long shipId, Long serviceId) {
        shipserviceRepository.deleteAllByShip_IdAndService_Id(shipId, serviceId);
    }

    @Override
    public List<Shipservice> findAllByShipIdServiceId(Long shipId, Long serviceId) {
        return shipserviceRepository.findByShip_IdAndService_Id(shipId, serviceId);
    }

    @Override
    public List<Shipservice> findAllServicesByShipId(Long id) {
        return shipserviceRepository.findAllByShip_Id(id);
    }
}
