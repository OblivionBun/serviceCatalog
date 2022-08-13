package ru.turboeggs.services.dto;

import lombok.*;

import java.util.UUID;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServiceObjectDto {

    UUID id;

    /**
     * Название услуги
     */
    String name;

    /**
     * Кол-во оборудования
     */
    Integer amount;
}
