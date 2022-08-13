package ru.turboeggs.services.db.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "service")
public class ServiceObjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    UUID id;

    /**
     * Название услуги
     */
    @Column
    String name;

    /**
     * Кол-во оборудования
     */
    @Column
    Integer amount;
}
