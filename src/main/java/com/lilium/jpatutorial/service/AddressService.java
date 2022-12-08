package com.lilium.jpatutorial.service;

import com.lilium.jpatutorial.entity.Address;
import com.lilium.jpatutorial.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddressService {
    private AddressRepository repository;

    @Autowired
    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    public Address createAddress(String name) {
        Address address = new Address();
        address.setCreatedTimestamp(System.currentTimeMillis());
        address.setModifiedTimestamp(address.getCreatedTimestamp());
        address.setName(name);

        return repository.save(address);
    }

    public Address findAddressById(String id) {
        return repository.findById(id).orElse(null);
    }
}
