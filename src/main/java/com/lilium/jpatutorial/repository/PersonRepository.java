package com.lilium.jpatutorial.repository;

import com.lilium.jpatutorial.entity.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends DistributedRepository<Person> {

    class Specs {
    }
}