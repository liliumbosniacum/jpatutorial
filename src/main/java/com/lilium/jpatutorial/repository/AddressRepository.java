package com.lilium.jpatutorial.repository;

import com.lilium.jpatutorial.entity.Address;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends DistributedRepository<Address> {
}
