package ua.study.poject.cruise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.study.poject.cruise.persistance.entity.*;
import ua.study.poject.cruise.persistance.entity.dto.DtoCruisePorts;
import ua.study.poject.cruise.persistance.entity.printableentity.PrintableCruise;
import ua.study.poject.cruise.persistance.dao.ICruise;
import ua.study.poject.cruise.persistance.dao.ICruisePorts;
import ua.study.poject.cruise.persistance.dao.IPrintableCruise;
import ua.study.poject.cruise.persistance.dao.ITicketclass;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CruiseService {

    @Autowired
    ITicketclass ticketclassImpl;

    @Autowired
    ICruise cruiseImpl;

    @Autowired
    ICruisePorts cruisePortsImpl;

    @Autowired
    IPrintableCruise printableCruiseImpl;

    public List<Ticketclass> getAllTicketClasses() {
        return ticketclassImpl.findAll();
    }


    @Transactional
    public String createCruise(DtoCruisePorts dto) {

        List<CruisePorts> cruisePortsList = new ArrayList<>();

        if (validate(dto.getDatestart(), dto.getDatestart(), dto.getSelectedportstart()))
            cruisePortsList.add(createCruisePorts(null, dto.getDatestart(), dto.getSelectedportstart()));

        if (validate(dto.getDate1in(), dto.getDate1out(), dto.getSelectedport1()))
            cruisePortsList.add(createCruisePorts(dto.getDate1in(), dto.getDate1out(), dto.getSelectedport1()));

        if (validate(dto.getDate2in(), dto.getDate2out(), dto.getSelectedport2()))
            cruisePortsList.add(createCruisePorts(dto.getDate2in(), dto.getDate2out(), dto.getSelectedport2()));

        if (validate(dto.getDate3in(), dto.getDate3out(), dto.getSelectedport3()))
            cruisePortsList.add(createCruisePorts(dto.getDate3in(), dto.getDate3out(), dto.getSelectedport3()));

        if (validate(dto.getDate4in(), dto.getDate4out(), dto.getSelectedport4()))
            cruisePortsList.add(createCruisePorts(dto.getDate4in(), dto.getDate4out(), dto.getSelectedport4()));

        if (validate(dto.getDate5in(), dto.getDate5out(), dto.getSelectedport5()))
            cruisePortsList.add(createCruisePorts(dto.getDate5in(), dto.getDate5out(), dto.getSelectedport5()));

        if (validate(dto.getDate6in(), dto.getDate6out(), dto.getSelectedport6()))
            cruisePortsList.add(createCruisePorts(dto.getDate6in(), dto.getDate6out(), dto.getSelectedport6()));

        if (validate(dto.getDate7in(), dto.getDate7out(), dto.getSelectedport7()))
            cruisePortsList.add(createCruisePorts(dto.getDate6in(), dto.getDate6out(), dto.getSelectedport7()));

        if (validate(dto.getDatestop(), dto.getDatestop(), dto.getSelectedportstop()))
            cruisePortsList.add(createCruisePorts(dto.getDatestop(), null, dto.getSelectedportstop()));

        Cruise newCruise = new Cruise(dto.getSelectedship(), dto.getPriceFirstClass(), dto.getPriceSecondClass(),
                dto.getPriceThirdClass(), dto.getPriceFourthClass());

        cruiseImpl.save(newCruise);

        if (newCruise.getId() == null)
            return "message.createcruise.errcreate";

        for (CruisePorts tempCP : cruisePortsList) {
            tempCP.setCruise(newCruise);
            cruisePortsImpl.save(tempCP);
            if (tempCP.getId() == null)
                return "message.createcruise.errcreate";
        }
        return "message.createcruise.ok";
    }

    private boolean validate(LocalDateTime dateIn, LocalDateTime dateOut, Long portId) {
        return dateIn != null && dateOut != null && portId != null;
    }


    private CruisePorts createCruisePorts(LocalDateTime dateIn, LocalDateTime dateOut, Long portId) {
        Port currentPort = new Port();
        currentPort.setId(portId);

        CruisePorts cruisePorts = new CruisePorts();
        cruisePorts.setDateIn(dateIn);
        cruisePorts.setDateOut(dateOut);
        cruisePorts.setPort(currentPort);
        return cruisePorts;
    }

    public List<Cruise> viewAllCruises() {
        return cruiseImpl.findAll();
    }

    public List<PrintableCruise> viewAllPrintableCruises() {
        return printableCruiseImpl.findAllPrintableCruises();
    }


    public List<Cruise> getAllCruisesByShip(Ship ship) {
        return cruiseImpl.findAllByShip(ship);
    }

    public Optional<Cruise> findById(Long cruiseId) {
        return cruiseImpl.findById(cruiseId);
    }
}
