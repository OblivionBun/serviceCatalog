package ru.turboeggs.services.db.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;
import ru.turboeggs.services.db.entity.ServiceObjectEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ServiceObjectRepository extends JpaRepositoryImplementation<ServiceObjectEntity, UUID> {
    Long idSequence = 1L;

    @Override
    List<ServiceObjectEntity> findAll();

    @Override
    ServiceObjectEntity save(ServiceObjectEntity serviceObjectEntity);

    @Override
    ServiceObjectEntity saveAndFlush(ServiceObjectEntity serviceObjectEntity);

    @Override
    void delete(ServiceObjectEntity entity);

    @Override
    Optional<ServiceObjectEntity> findById(UUID id);
}

