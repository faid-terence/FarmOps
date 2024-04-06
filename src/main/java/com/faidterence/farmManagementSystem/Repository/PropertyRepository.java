package com.faidterence.farmManagementSystem.Repository;

import com.faidterence.farmManagementSystem.schema.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    Property findPropertyByName(String name);
}
