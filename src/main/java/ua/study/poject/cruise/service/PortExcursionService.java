package ua.study.poject.cruise.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.study.poject.cruise.persistance.entity.Excursion;
import ua.study.poject.cruise.persistance.entity.Port;
import ua.study.poject.cruise.persistance.dao.IExcursion;
import ua.study.poject.cruise.persistance.dao.IPort;

import java.util.List;
@Service
public class PortExcursionService {

    @Autowired
    IPort portImpl;

    @Autowired
    IExcursion excursionImpl;

    public String createPort(Port newPort) {
        if(newPort.getCity().equals("") || newPort.getCountry().equals(""))
            return "message.createport.errfaild";
        portImpl.save(newPort);
        return (newPort.getId() == null) ? "message.createport.errfaild" : "message.createport.ok";
    }


    public String createExcursion(Excursion newExcursion) {
        if(newExcursion.getExcursionName().equals("") || newExcursion.getDescription().equals(""))
            return "message.createexcursion.errfaild";
//        Excursion excursion = excursionImpl.findByExcursionName(newExcursion.getExcursionName());
//        if(excursion != null){
//            return "Такая экскурсия уже есть в системе";
//        }

        excursionImpl.save(newExcursion);
        return newExcursion.getId() == null  ? "message.createexcursion.errfaild" : "message.createexcursion.ok";
    }

    public List<Port> getAllPorts() {
        return portImpl.findAll();
    }

    public List<Excursion> ViewExcursionsInPortByPortId(Long portId) {
        return excursionImpl.findByPortId(portId);
    }

    public Excursion ViewExcursionsInPortById(Long excursionId) {
        return excursionImpl.findById(excursionId).orElse(new Excursion());
    }

    public Port getPortById(Long portId) {
        return portImpl.findById(portId).orElse(new Port());
    }
}
