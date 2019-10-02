package ua.study.poject.cruise.persistance.dao.springdata;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.study.poject.cruise.persistance.entity.Ticketclass;
import ua.study.poject.cruise.persistance.dao.ITicketclass;
import ua.study.poject.cruise.persistance.repository.TicketclassRepository;

import java.util.List;

@Repository
@NoArgsConstructor
@AllArgsConstructor
public class TicketclassImpl implements ITicketclass {

    @Autowired
    TicketclassRepository ticketclassRepository;

    @Override
    public List<Ticketclass> findAll() {
        return ticketclassRepository.findAll();
    }
}
