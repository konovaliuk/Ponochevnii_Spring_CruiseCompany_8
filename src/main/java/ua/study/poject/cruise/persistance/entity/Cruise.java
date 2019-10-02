package ua.study.poject.cruise.persistance.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
public class Cruise implements Serializable {

    private static final long serialVersionUID = 6044564832461110177L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ship_id", referencedColumnName = "id", nullable = false, updatable = false, foreignKey = @ForeignKey(name = "fk_cruise_ship1"))
    private Ship ship;

    @Column(name = "price_first_class", nullable = false)
    private double priceFirstClass;

    @Column(name = "price_second_class", nullable = false)
    private double priceSecondClass;

    @Column(name = "price_third_class", nullable = false)
    private double priceThirdClass;

    @Column(name = "price_fourth_class", nullable = false)
    private double priceFourthClass;

    public Cruise(Ship ship, double priceFirstClass, double priceSecondClass, double priceThirdClass, double priceFourthClass) {
        this.ship = ship;
        this.priceFirstClass = priceFirstClass;
        this.priceSecondClass = priceSecondClass;
        this.priceThirdClass = priceThirdClass;
        this.priceFourthClass = priceFourthClass;
    }
}
