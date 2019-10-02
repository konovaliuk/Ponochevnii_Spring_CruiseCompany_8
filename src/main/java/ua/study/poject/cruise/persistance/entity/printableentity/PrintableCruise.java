package ua.study.poject.cruise.persistance.entity.printableentity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.study.poject.cruise.persistance.entity.Cruise;
import ua.study.poject.cruise.persistance.entity.CruisePorts;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
public class PrintableCruise implements Serializable {

    private static final long serialVersionUID = -2063131958780642786L;

    private Cruise cruise;
    private List<CruisePorts> cruisePortsList;

    public PrintableCruise(Cruise cruise, List<CruisePorts> cruisePortsList) {
        this.cruise = cruise;
        this.cruisePortsList = cruisePortsList;
    }
}
