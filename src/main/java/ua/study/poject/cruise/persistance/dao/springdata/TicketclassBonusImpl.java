package ua.study.poject.cruise.persistance.dao.springdata;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.study.poject.cruise.persistance.dao.ITicketclassBonus;
import ua.study.poject.cruise.persistance.entity.TicketclassBonus;
import ua.study.poject.cruise.persistance.repository.TicketclassBonusRepository;

import java.util.List;

@Repository
@NoArgsConstructor
public class TicketclassBonusImpl implements ITicketclassBonus {

    @Autowired
    TicketclassBonusRepository ticketclassBonusRepository;

    @Override
    public TicketclassBonus create(TicketclassBonus ticketclassBonus) {
        return ticketclassBonusRepository.save(ticketclassBonus);
    }

    @Override
    public void deleteByShipserviceId(Long id) {
        ticketclassBonusRepository.deleteByShipService_Id(id);
    }

    @Override
    public void deleteAllByListId(List<Long> listId) {
        for (Long currentId : listId)
            ticketclassBonusRepository.deleteById(currentId);
    }

    @Override
    public List<TicketclassBonus> findAllBonusesByCruiseIdTicketclassName(Long cruiseId, String ticketclassName) {
        return ticketclassBonusRepository.findAllByCruise_IdAndTicketclass_TicketclassName(cruiseId, ticketclassName);
    }


}
