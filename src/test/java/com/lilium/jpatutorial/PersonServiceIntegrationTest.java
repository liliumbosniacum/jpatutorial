package com.lilium.jpatutorial;

import com.lilium.jpatutorial.entity.Address;
import com.lilium.jpatutorial.entity.Person;
import com.lilium.jpatutorial.service.AddressService;
import com.lilium.jpatutorial.service.PersonService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class PersonServiceIntegrationTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PersonService service;
    @Autowired
    private AddressService addressService;

    @Test
    void testCreatePerson() {
        final Address address = addressService.createAddress("Address name");

        final Person james = service.createPerson(
                "James",
                "+43000123",
                address
        );

        assertThat(james).isNotNull();

        final Person jamesById = service.getById(james.getId());
        assertThat(jamesById)
                .isNotNull()
                .extracting(Person::getPhoneNumber)
                .isEqualTo(james.getPhoneNumber());

        final Address jamesAddress = entityManager.find(
                Address.class,
                jamesById.getAddress().getId()
        );
        assertThat(jamesAddress)
                .isNotNull()
                .extracting(Address::getName)
                .isEqualTo(address.getName());
    }
}
