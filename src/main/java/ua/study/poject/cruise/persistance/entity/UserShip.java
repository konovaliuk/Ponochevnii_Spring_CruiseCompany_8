package ua.study.poject.cruise.persistance.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "user_ship")
public class UserShip implements Serializable {

    private static final long serialVersionUID = 771604680373740084L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ship_id", nullable = false, foreignKey = @ForeignKey(name = "fk_user_ship_ship1"))
    private Ship ship;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_user_ship_user1"))
    private User user;

    public UserShip(Ship ship, User user) {
        this.ship = ship;
        this.user = user;
    }
}
