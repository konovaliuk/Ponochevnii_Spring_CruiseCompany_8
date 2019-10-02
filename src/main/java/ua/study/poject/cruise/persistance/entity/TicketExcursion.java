package ua.study.poject.cruise.persistance.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "ticket_excursion")
public class TicketExcursion implements Serializable {

    private static final long serialVersionUID = -2868235177294734744L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "excurision_id", nullable = false, foreignKey = @ForeignKey(name = "fk_ticket_excursion_excurision1"))
    private Excursion excursion;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_ticket_excursion_user1"))
    private User user;

    public TicketExcursion(Excursion excursion, User user) {
        this.excursion = excursion;
        this.user = user;
    }
}
