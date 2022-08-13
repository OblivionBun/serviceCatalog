package ru.turboeggs.services.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.turboeggs.services.dto.ServiceObjectDto;
import ru.turboeggs.services.mappers.ServiceObjectMapper;
import ru.turboeggs.services.services.ServiceObjectService;

import java.util.List;
import java.util.UUID;


@RequiredArgsConstructor
@RestController
@RequestMapping("services")
public class ServiceObjectController {

    private final ServiceObjectService serviceObjectService;

    @PostMapping("/create")
    public ResponseEntity<UUID> create(@RequestBody ServiceObjectDto serviceObjectDto) {
        return ResponseEntity.ok(serviceObjectService.createServiceObject(ServiceObjectMapper.mapFromDto(serviceObjectDto)));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<UUID> update(@PathVariable(value = "id") UUID id, @RequestBody ServiceObjectDto serviceObjectDto) {
        serviceObjectDto.setId(id);
        return ResponseEntity.ok(serviceObjectService.updateServiceObject(ServiceObjectMapper.mapFromDto(serviceObjectDto)));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ServiceObjectDto>> getServices() {
        return ResponseEntity.ok(serviceObjectService.getAll().stream()
                .map(ServiceObjectMapper::mapToDto)
                .toList()
        );
    }
}
