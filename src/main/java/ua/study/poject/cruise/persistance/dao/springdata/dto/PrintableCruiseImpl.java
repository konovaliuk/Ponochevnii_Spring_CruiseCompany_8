package ua.study.poject.cruise.persistance.dao.springdata.dto;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.study.poject.cruise.persistance.dao.ICruise;
import ua.study.poject.cruise.persistance.dao.ICruisePorts;
import ua.study.poject.cruise.persistance.dao.IPrintableCruise;
import ua.study.poject.cruise.persistance.entity.Cruise;
import ua.study.poject.cruise.persistance.entity.CruisePorts;
import ua.study.poject.cruise.persistance.entity.printableentity.PrintableCruise;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@NoArgsConstructor
public class PrintableCruiseImpl implements IPrintableCruise {

    @Autowired
    ICruise cruiseImpl;
    @Autowired
    ICruisePorts cruisePortsImpl;

    @Override
    public List<PrintableCruise> findAllPrintableCruises() {
        List<PrintableCruise> result = new ArrayList<>();
        List<Cruise> cruiseList = cruiseImpl.findAll();
        for (Cruise cruise : cruiseList) {
            List<CruisePorts> byCruiseId = cruisePortsImpl.findByCruiseId(cruise.getId());
            if (byCruiseId == null) {
                continue;
            }
            result.add(new PrintableCruise(cruise, byCruiseId));
        }
        return result;
    }

    @Override
    public PrintableCruise findPrintableCruiseByCruiseId(Long id) {
        PrintableCruise printableCruise = new PrintableCruise();
        Optional<Cruise> cruiseOptional = cruiseImpl.findById(id);
        if (!cruiseOptional.isPresent()) {
            return null;
        }

        printableCruise.setCruise(cruiseOptional.get());
        printableCruise.setCruisePortsList(cruisePortsImpl.findByCruiseId(id));
        return printableCruise;
    }
}
