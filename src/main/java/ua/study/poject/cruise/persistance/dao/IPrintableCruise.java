package ua.study.poject.cruise.persistance.dao;


import ua.study.poject.cruise.persistance.entity.printableentity.PrintableCruise;

import java.util.List;

/**
 * The interface IPrintableCruise defines an interaction contract with a PrintableCruise entity
 */
public interface IPrintableCruise {

    /**
     * This method finds all the PrintableCruises
     *
     * @return List of PrintableCruises
     */
    List<PrintableCruise> findAllPrintableCruises();

    /**
     * This method finds a PrintableCruise by "Cruise id"
     *
     * @param id
     * @return PrintableCruise
     */
    PrintableCruise findPrintableCruiseByCruiseId(Long id);
}
