package ua.study.poject.cruise.persistance.entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
public class Ticket implements Serializable {

    private static final long serialVersionUID = -330485337763281300L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_ticket_user1"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "cruise_id", nullable = false, foreignKey = @ForeignKey(name = "fk_ticket_cruise1"))
    private Cruise cruise;

    @ManyToOne
    @JoinColumn(name = "ticketclass_id", nullable = false, foreignKey = @ForeignKey(name = "fk_ticket_ticketclass1"))
    private Ticketclass ticketclass;

    public Ticket(User user, Cruise cruise, Ticketclass ticketclass) {
        this.user = user;
        this.cruise = cruise;
        this.ticketclass = ticketclass;
    }
}
