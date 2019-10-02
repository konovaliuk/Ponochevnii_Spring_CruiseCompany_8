package ua.study.poject.cruise.persistance.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
public class Service implements Serializable {

    private static final long serialVersionUID = -8318857418394911131L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "service_name", unique = true, nullable = false)
    private String serviceName;

    public Service(String serviceName) {
        this.serviceName = serviceName;
    }
}

