package ua.study.poject.cruise.persistance.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
public class Ship implements Serializable {

    private static final long serialVersionUID = 3628196289181782375L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ship_name", nullable = false)
    private String shipName;

    @Column(name = "n_staff", nullable = false)
    private Long nStaff;

    @Column(name = "n_first_class", nullable = false)
    private Long nFirstClass;

    @Column(name = "n_second_class", nullable = false)
    private Long nSecondClass;

    @Column(name = "n_third_class", nullable = false)
    private Long nThirdClass;

    @Column(name = "n_fourth_class", nullable = false)
    private Long nFourthClass;

    public Long getNStaff() {
        return this.nStaff;
    }

    public Long getNFirstClass() {
        return this.nFirstClass;
    }

    public Long getNSecondClass() {
        return this.nSecondClass;
    }

    public Long getNThirdClass() {
        return this.nThirdClass;
    }

    public Long getNFourthClass() {
        return this.nFourthClass;
    }

    public void setNStaff(Long nStaff) {
        this.nStaff = nStaff;
    }

    public void setNFirstClass(Long nFirstClass) {
        this.nFirstClass = nFirstClass;
    }

    public void setNSecondClass(Long nSecondClass) {
        this.nSecondClass = nSecondClass;
    }

    public void setNThirdClass(Long nThirdClass) {
        this.nThirdClass = nThirdClass;
    }

    public void setNFourthClass(Long nFourthClass) {
        this.nFourthClass = nFourthClass;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Ship;
    }

    public Ship(String shipName, Long nStaff, Long nFirstClass, Long nSecondClass, Long nThirdClass, Long nFourthClass) {
        this.shipName = shipName;
        this.nStaff = nStaff;
        this.nFirstClass = nFirstClass;
        this.nSecondClass = nSecondClass;
        this.nThirdClass = nThirdClass;
        this.nFourthClass = nFourthClass;
    }
}
