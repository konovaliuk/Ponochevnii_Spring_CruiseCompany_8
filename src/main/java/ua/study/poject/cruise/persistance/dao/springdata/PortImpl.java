package ua.study.poject.cruise.persistance.dao.springdata;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.study.poject.cruise.persistance.dao.IPort;
import ua.study.poject.cruise.persistance.entity.Port;
import ua.study.poject.cruise.persistance.repository.PortRepository;

import java.util.List;
import java.util.Optional;

@Repository
@NoArgsConstructor
public class PortImpl implements IPort {

    @Autowired
    PortRepository portRepository;

    @Override
    public Port save(Port port) {
        return portRepository.save(port);
    }

    @Override
    public List<Port> findAll() {
        return portRepository.findAll();
    }

    @Override
    public Optional<Port> findById(Long id) {
        return portRepository.findById(id);
    }
}
