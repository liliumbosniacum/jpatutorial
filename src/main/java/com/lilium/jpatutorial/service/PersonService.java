package com.lilium.jpatutorial.service;

import com.lilium.jpatutorial.entity.Address;
import com.lilium.jpatutorial.entity.Person;
import com.lilium.jpatutorial.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person createPerson(final String name,
                               final String phoneNumber,
                               final Address address) {
        final Person person = new Person();
        person.setName(name);
        person.setPhoneNumber(phoneNumber);
        person.setAddress(address);
        person.setCreatedTimestamp(System.currentTimeMillis());
        person.setModifiedTimestamp(System.currentTimeMillis());

        return repository.save(person);
    }

    public Person getById(final String id) {
        return repository.findById(id).orElse(null);
    }
}
