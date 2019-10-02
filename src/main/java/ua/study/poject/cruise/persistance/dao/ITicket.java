package ua.study.poject.cruise.persistance.dao;

import ua.study.poject.cruise.persistance.entity.Ticket;
import ua.study.poject.cruise.persistance.entity.User;

import java.util.List;
import java.util.Optional;

public interface ITicket {

    Ticket create(Ticket ticket);

    List<Ticket> findAll();

    Optional<Ticket> findById(Long id);

    List<Ticket> findTicketByUser(User user);
}
