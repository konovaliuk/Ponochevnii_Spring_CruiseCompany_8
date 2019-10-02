package ua.study.poject.cruise.persistance.dao;


import ua.study.poject.cruise.persistance.entity.Cruise;
import ua.study.poject.cruise.persistance.entity.Ship;
import ua.study.poject.cruise.persistance.entity.printableentity.PrintableCruise;

import java.util.List;

public interface IPrintableCruise {

    List<PrintableCruise> findAllPrintableCruises();

    List<Cruise> findAllCruisesByShip(Ship ship);

    PrintableCruise findPrintableCruiseByCruiseId(Long id);
}
