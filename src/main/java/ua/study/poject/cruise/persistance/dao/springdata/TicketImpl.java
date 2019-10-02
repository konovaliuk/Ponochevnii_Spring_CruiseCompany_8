package ua.study.poject.cruise.persistance.dao.springdata;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.study.poject.cruise.persistance.dao.ITicket;
import ua.study.poject.cruise.persistance.entity.Ticket;
import ua.study.poject.cruise.persistance.entity.User;
import ua.study.poject.cruise.persistance.repository.TicketRepository;

import java.util.List;
import java.util.Optional;

@Repository
@NoArgsConstructor
@AllArgsConstructor
public class TicketImpl implements ITicket {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public Ticket create(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        return ticketRepository.findById(id);
    }

    @Override
    public List<Ticket> findTicketByUser(User user) {
        return ticketRepository.findAllByUser(user);
    }

}
