package ua.study.poject.cruise.persistance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Ticketclass implements Serializable {

    private static final long serialVersionUID = -5494317862733917049L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticketclass_name", nullable = false, unique = true)
    private String ticketclassName;

    public Ticketclass(String ticketclassName) {
        this.ticketclassName = ticketclassName;
    }

    public static final String TICKET_CLASS_FIRST = "first";
    public static final String TICKET_CLASS_SECOND = "second";
    public static final String TICKET_CLASS_THIRD = "third";
    public static final String TICKET_CLASS_FOURTH = "fourth";


}
