package ua.study.poject.cruise.persistance.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "excurision")
public class Excursion implements Serializable {

    private static final long serialVersionUID = 3264696485164034465L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "excursion_name", nullable = false)
    private String excursionName;
    private double price;

    @Column(length = 8000, nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "port_id", nullable = false, foreignKey = @ForeignKey(name = "fk_excurision_port1"))
    private Port port;

    public Excursion(String excursionName, double price, String description, Port port) {
        this.excursionName = excursionName;
        this.price = price;
        this.description = description;
        this.port = port;
    }
}
