package com.lilium.jpatutorial.repository;

import com.lilium.jpatutorial.entity.Address;
import com.lilium.jpatutorial.entity.Address_;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends DistributedRepository<Address> {

    class Specs {
        private static final Logger LOG = LoggerFactory.getLogger(AddressRepository.class);
        public static Specification<Address> byName(final String pattern) {
            LOG.info("Building specification byName with following pattern '{}'", pattern);

            return (root, query, cb) -> cb.like(
                    root.get(Address_.NAME),
                    pattern
            );
        }
    }
}