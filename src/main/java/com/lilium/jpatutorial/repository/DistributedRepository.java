package com.lilium.jpatutorial.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface DistributedRepository<ENTITY> extends JpaRepository<ENTITY, String> {

    List<ENTITY> findAllCreatedSince(Long timestamp);

    List<ENTITY> findAll(Specification<ENTITY> specification);
}