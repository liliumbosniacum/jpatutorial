package com.lilium.jpatutorial;

import com.lilium.jpatutorial.entity.Address;
import com.lilium.jpatutorial.service.AddressService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AddressServiceIntegrationTest {
    @Autowired
    private AddressService service;

    @Test
    void testCreateAndFindAddress() {
        final Address savedAddress = service.createAddress("221B Baker St., London");

        Assertions.assertThat(savedAddress).isNotNull();

        Address addressById = service.findAddressById(savedAddress.getId());
        Assertions.assertThat(addressById)
                .isNotNull()
                .extracting(Address::getName)
                .isEqualTo(savedAddress.getName());
    }
}
