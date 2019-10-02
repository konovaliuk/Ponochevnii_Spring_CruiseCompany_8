package ua.study.poject.cruise.persistance.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@NoArgsConstructor
public class Port implements Serializable {

    private static final long serialVersionUID = -6613423184151095384L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;

    public Port(String country, String city) {
        this.country = country;
        this.city = city;
    }
}
