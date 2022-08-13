package ru.turboeggs.services.mappers;

import ru.turboeggs.services.db.entity.ServiceObjectEntity;
import ru.turboeggs.services.dto.ServiceObjectDto;

public class ServiceObjectMapper {
    public static ServiceObjectEntity mapFromDto(ServiceObjectDto serviceObjectDto) {
        return ServiceObjectEntity.builder()
                .id(serviceObjectDto.getId())
                .name(serviceObjectDto.getName())
                .amount(serviceObjectDto.getAmount())
                .build();
    }

    public static ServiceObjectDto mapToDto(ServiceObjectEntity serviceObjectEntity) {
        return ServiceObjectDto.builder()
                .id(serviceObjectEntity.getId())
                .name(serviceObjectEntity.getName())
                .amount(serviceObjectEntity.getAmount())
                .build();
    }
}
