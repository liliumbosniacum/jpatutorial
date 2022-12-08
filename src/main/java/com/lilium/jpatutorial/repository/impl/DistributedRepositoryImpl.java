package com.lilium.jpatutorial.repository.impl;

import com.lilium.jpatutorial.repository.DistributedRepository;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class DistributedRepositoryImpl<ENTITY> extends SimpleJpaRepository<ENTITY, String>
        implements DistributedRepository<ENTITY> {

    public DistributedRepositoryImpl(final JpaEntityInformation<ENTITY, String> entityInformation,
                                     final EntityManager entityManager) {
        super(entityInformation, entityManager);
    }
}
