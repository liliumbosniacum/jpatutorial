package com.lilium.jpatutorial.repository.impl;

import com.lilium.jpatutorial.entity.DistributedEntity_;
import com.lilium.jpatutorial.repository.DistributedRepository;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.List;

public class DistributedRepositoryImpl<ENTITY> extends SimpleJpaRepository<ENTITY, String>
        implements DistributedRepository<ENTITY> {

    public DistributedRepositoryImpl(final JpaEntityInformation<ENTITY, String> entityInformation,
                                     final EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    @Override
    public List<ENTITY> findAllCreatedSince(Long timestamp) {
        return findAll(createdSince(timestamp));
    }

    @Override
    public List<ENTITY> findAll(Specification<ENTITY> specification) {
        return super.findAll(specification);
    }

    /**
     * Used to find all entities created since forwarded timestamp.
     *
     * @param timestamp Timestamp since which entities were created.
     * @return Returns created specification.
     */
    private Specification<ENTITY> createdSince(final Long timestamp) {
        return ((root, query, cb) -> cb.greaterThanOrEqualTo(
                root.get(DistributedEntity_.CREATED_TIMESTAMP),
                timestamp
        ));
    }
}