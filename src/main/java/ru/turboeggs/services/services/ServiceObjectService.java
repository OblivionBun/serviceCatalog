package ru.turboeggs.services.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.turboeggs.services.db.entity.ServiceObjectEntity;
import ru.turboeggs.services.db.repository.ServiceObjectRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ServiceObjectService {
    private final ServiceObjectRepository serviceObjectRepository;

    public UUID createServiceObject(ServiceObjectEntity serviceObjectEntity) {
        return serviceObjectRepository.save(serviceObjectEntity).getId();
    }

    public List<ServiceObjectEntity> getAll() {
        return serviceObjectRepository.findAll();
    }

    public UUID updateServiceObject(ServiceObjectEntity serviceObjectToUpdate) {
        var serviceObject = serviceObjectRepository.findById(serviceObjectToUpdate.getId());

        // если объекта с таким id нет, то бросаем 400-ку
        if (serviceObject.isEmpty()) {
            throw new IllegalArgumentException(String.format("Service with id = %s not exists", serviceObjectToUpdate.getId()));
        }

        // если имя и кол-во пустые, то в базе ничего не изменится, поэтому просто возвращаем id'шник
        if (serviceObjectToUpdate.getName() == null && serviceObjectToUpdate.getAmount() == null) {
            return serviceObject.get().getId();
        }

        // если кол-во пустое, то имя точно не пустое, так что кол-во в БД не меняем, а имя в БД меняем
        if (serviceObjectToUpdate.getAmount() == null) {
            serviceObjectToUpdate.setAmount(serviceObject.get().getAmount());
            return serviceObjectRepository.saveAndFlush(serviceObjectToUpdate).getId();
        }

        // если имя пустое, то кол-во точно не пустое, так что имя в БД не меняем, а кол-во в БД меняем
        if (serviceObjectToUpdate.getName() == null) {
            serviceObjectToUpdate.setName(serviceObject.get().getName());
            return serviceObjectRepository.saveAndFlush(serviceObjectToUpdate).getId();
        }

        // остаётся вариант, где ничего не пустое, тогда просто перезаписываем объект в БД
        return serviceObjectRepository.saveAndFlush(serviceObjectToUpdate).getId();
    }

}
