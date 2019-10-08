package ua.study.poject.cruise.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.study.poject.cruise.persistance.dao.IExcursion;
import ua.study.poject.cruise.persistance.dao.IPort;
import ua.study.poject.cruise.persistance.entity.Excursion;
import ua.study.poject.cruise.persistance.entity.Port;

import java.util.List;

/**
 * This is a class that contains logic for working with Port and Excursion entities
 */
@Service
public class PortExcursionService {

    @Autowired
    IPort portImpl;

    @Autowired
    IExcursion excursionImpl;

    /**
     * The method creates new Port
     *
     * @param newPort
     * @return message for user
     */
    public String createPort(Port newPort) {
        if (newPort.getCity().equals("") || newPort.getCountry().equals("")) {
            return "message.createport.errfaild";
        }
        portImpl.save(newPort);
        return (newPort.getId() == null) ? "message.createport.errfaild" : "message.createport.ok";
    }


    /**
     * The method creates new Excursion
     *
     * @param newExcursion
     * @return message for user
     */
    public String createExcursion(Excursion newExcursion) {
        if (newExcursion.getExcursionName().equals("") || newExcursion.getDescription().equals("")) {
            return "message.createexcursion.errfaild";
        }
        excursionImpl.save(newExcursion);
        return newExcursion.getId() == null ? "message.createexcursion.errfaild" : "message.createexcursion.ok";
    }

    /**
     * the method finds all the ports that are in the system
     *
     * @return List of Port or empty list if the search was unsuccessful
     */
    public List<Port> getAllPorts() {
        return portImpl.findAll();
    }

    /**
     * The method finds excursion by "Port id"
     *
     * @param portId
     * @return List of Excursion or empty list if the search was unsuccessful
     */
    public List<Excursion> viewExcursionsInPortByPortId(Long portId) {
        return excursionImpl.findByPortId(portId);
    }

    /**
     * The method finds excursion by "id"
     *
     * @param excursionId
     * @return Excursion or null if the search failed
     */
    public Excursion viewExcursionsInPortById(Long excursionId) {
        return excursionImpl.findById(excursionId).orElse(new Excursion());
    }

    /**
     * The method finds "Port" by "id"
     *
     * @param portId
     * @return Port or null if the search failed
     */
    public Port getPortById(Long portId) {
        return portImpl.findById(portId).orElse(new Port());
    }
}
