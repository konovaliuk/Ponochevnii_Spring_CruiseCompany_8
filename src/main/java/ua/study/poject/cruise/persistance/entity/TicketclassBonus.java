package ua.study.poject.cruise.persistance.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "ticketclass_bonus")
public class TicketclassBonus implements Serializable {

    private static final long serialVersionUID = 9184949170104737061L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ticketclass_id", nullable = false, foreignKey = @ForeignKey(name = "fk_ticketclass_bonus_ticketclass1"))
    private Ticketclass ticketclass;

    @ManyToOne
    @JoinColumn(name = "ship_service_id", nullable = false, foreignKey = @ForeignKey(name = "fk_ticketclass_bonus_ship_service1"))
    private Shipservice shipService;

    @ManyToOne
    @JoinColumn(name = "cruise_id", nullable = false, foreignKey = @ForeignKey(name = "fk_ticketclass_bonus_cruise1"))
    private Cruise cruise;

    public TicketclassBonus(Ticketclass ticketclass, Shipservice shipService, Cruise cruise) {
        this.ticketclass = ticketclass;
        this.shipService = shipService;
        this.cruise = cruise;
    }
}
