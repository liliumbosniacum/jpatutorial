package com.lilium.jpatutorial;

import com.lilium.jpatutorial.entity.Address;
import com.lilium.jpatutorial.repository.AddressRepository;
import com.lilium.jpatutorial.service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AddressRepositoryTest {
    @Autowired
    private AddressService service;

    @Autowired
    private AddressRepository repository;

    /**
     * Creates two addresses and verifies that they can be found via correct timestamps.
     */
    @Test
    void testFindCreatedSince() {
        // Cache timestamp before any address is created
        final long beforeAllCreateTimestamp = System.currentTimeMillis();

        // Create first address
        final Address firstCreatedAddress = service.createAddress("698 Candlewood Lane, Cabot Cove, Maine");
        // Cache timestamp before second address is created
        final long beforeCreateSecondAddressTimestamp = System.currentTimeMillis();
        // Create second address
        final Address secondCreatedAddress = service.createAddress("9764 Jeopardy Lane, Chicago, Illinois");

        // Find all address with current timestamp and verify that none are found
        List<Address> allCreatedSince = repository.findAllCreatedSince(System.currentTimeMillis());
        assertThat(allCreatedSince)
                .isNotNull()
                .isEmpty();

        // Find all addresses created since 'beforeCreateSecondAddressTimestamp' and verify that only second address is
        // found
        allCreatedSince = repository.findAllCreatedSince(beforeCreateSecondAddressTimestamp);
        assertThat(allCreatedSince)
                .isNotNull()
                .extracting(Address::getId)
                .containsExactly(secondCreatedAddress.getId());

        // Find all addresses created since 'beforeAllCreateTimestamp' and verify that all addresses (first and second)
        // are found
        allCreatedSince = repository.findAllCreatedSince(beforeAllCreateTimestamp);
        assertThat(allCreatedSince)
                .isNotNull()
                .extracting(Address::getId)
                .containsExactlyInAnyOrder(firstCreatedAddress.getId(), secondCreatedAddress.getId());
    }

    @Test
    void findAddressByName() {
        final Address firstCreatedAddress = service.createAddress("742 Evergreen Terrace, Springfield, USA");
        final Address secondCreatedAddress = service.createAddress("Oxenthorpe Road, Puddleby-on-the-Marsh, Slopshire, England");

        // Search for address by name that does not exist
        List<Address> foundAddresses = repository.findAll(AddressRepository.Specs.byName("I.do.not.exist"));
        assertThat(foundAddresses)
                .isNotNull()
                .isEmpty();

        // Search for first address by its name
        foundAddresses = repository.findAll(AddressRepository.Specs.byName(firstCreatedAddress.getName()));
        assertThat(foundAddresses)
                .isNotNull()
                .extracting(Address::getId)
                .containsExactly(firstCreatedAddress.getId());

        // Search for second address by part of its name
        foundAddresses = repository.findAll(AddressRepository.Specs.byName("%ngland"));
        assertThat(foundAddresses)
                .isNotNull()
                .extracting(Address::getId)
                .containsExactly(secondCreatedAddress.getId());
    }
}