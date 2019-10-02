package ua.study.poject.cruise.persistance.dao.springdata;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.study.poject.cruise.persistance.entity.TicketExcursion;
import ua.study.poject.cruise.persistance.entity.User;
import ua.study.poject.cruise.persistance.dao.ITicketExcursion;
import ua.study.poject.cruise.persistance.repository.TicketExcursionRepository;

import java.util.List;

@Repository
@NoArgsConstructor
@AllArgsConstructor
public class TicketExcursionImpl implements ITicketExcursion {

    @Autowired
    TicketExcursionRepository ticketExcursionRepository;

    @Override
    public TicketExcursion create(TicketExcursion ticketExcursion) {
        return ticketExcursionRepository.save(ticketExcursion);
    }

    @Override
    public List<TicketExcursion> findAllByUser(User user) {
        return ticketExcursionRepository.findAllByUser(user);
    }
}
