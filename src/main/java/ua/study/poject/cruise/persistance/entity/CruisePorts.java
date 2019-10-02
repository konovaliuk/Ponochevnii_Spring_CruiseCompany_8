package ua.study.poject.cruise.persistance.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cruise_ports")
public class CruisePorts implements Serializable {

    private static final long serialVersionUID = -2937285422424704194L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_in")
    private LocalDateTime dateIn;

    @Column(name = "date_out")
    private LocalDateTime dateOut;

    @ManyToOne
    @JoinColumn(name = "cruise_id", nullable = false, foreignKey = @ForeignKey(name = "fk_cruise_ports_cruise1"))
    private Cruise cruise;

    @ManyToOne
    @JoinColumn(name = "port_id", nullable = false, foreignKey = @ForeignKey(name = "fk_cruise_ports_port1"))
    private Port port;

    public CruisePorts(LocalDateTime dateIn, LocalDateTime dateOut, Cruise cruise, Port port) {
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.cruise = cruise;
        this.port = port;
    }
}
