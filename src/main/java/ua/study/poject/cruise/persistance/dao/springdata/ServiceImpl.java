package ua.study.poject.cruise.persistance.dao.springdata;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.study.poject.cruise.persistance.dao.IService;
import ua.study.poject.cruise.persistance.entity.Service;
import ua.study.poject.cruise.persistance.repository.ServiceRepository;

import java.util.List;
import java.util.Optional;

@Repository
@NoArgsConstructor
public class ServiceImpl implements IService {

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public Service create(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Optional<Service> findById(Long id) {
        return serviceRepository.findById(id);
    }

    @Override
    public Service findByName(String serviceName) {
        return serviceRepository.findByServiceName(serviceName);
    }
}
