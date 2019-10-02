package ua.study.poject.cruise.persistance.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "ship_service")
public class Shipservice implements Serializable {

    private static final long serialVersionUID = -6672039886624328107L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ship_id", nullable = false, foreignKey = @ForeignKey(name = "fk_shipservice_ship1"))
    private Ship ship;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false, foreignKey = @ForeignKey(name = "fk_shipservice_service1"))
    private Service service;

    private Integer payable;

    public Shipservice(Ship ship, Service service, Integer payable) {
        this.ship = ship;
        this.service = service;
        this.payable = payable;
    }
}
