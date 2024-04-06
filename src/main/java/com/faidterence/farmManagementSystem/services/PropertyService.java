package com.faidterence.farmManagementSystem.services;

import com.faidterence.farmManagementSystem.Repository.PropertyRepository;
import com.faidterence.farmManagementSystem.dto.CreatePropertyDTO;
import com.faidterence.farmManagementSystem.schema.Property;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class PropertyService {

    private final PropertyRepository propertyRepository;


    public Property createProperty(CreatePropertyDTO createPropertyDTO) {
        String name = createPropertyDTO.getName();
        Property existingProperty = propertyRepository.findPropertyByName(name);

        if(existingProperty != null) {
            throw new IllegalArgumentException("Property with name " + name + " already exists");
        }
        Property property = new Property();
        property.setName(createPropertyDTO.getName());
        property.setLocation(createPropertyDTO.getLocation());
        property.setDescription(createPropertyDTO.getDescription());
        property.setCategory(createPropertyDTO.getCategory());
        property.setStatus(createPropertyDTO.getStatus());
        property.setPrice(createPropertyDTO.getPrice());
        property.setQuantity(createPropertyDTO.getQuantity());
        property.setOwner(createPropertyDTO.getOwner());
        property.setContact(createPropertyDTO.getContact());
        property.setDate(createPropertyDTO.getDate());
        return propertyRepository.save(property);

    }

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id).orElseThrow(() -> new RuntimeException("Property not found"));
    }

    public void deleteProperty(Long id) {
        long propertyId = id;
        Property existingProperty = propertyRepository.findById(propertyId).orElseThrow(() -> new RuntimeException("Property not found"));
        propertyRepository.delete(existingProperty);
    }

    public Property updateProperty(Long id, CreatePropertyDTO createPropertyDTO) {
        long propertyId = id;
        Property existingProperty = propertyRepository.findById(propertyId).orElseThrow(() -> new RuntimeException("Property not found"));
        existingProperty.setName(createPropertyDTO.getName());
        existingProperty.setLocation(createPropertyDTO.getLocation());
        existingProperty.setDescription(createPropertyDTO.getDescription());
        existingProperty.setCategory(createPropertyDTO.getCategory());
        existingProperty.setStatus(createPropertyDTO.getStatus());
        existingProperty.setPrice(createPropertyDTO.getPrice());
        existingProperty.setQuantity(createPropertyDTO.getQuantity());
        existingProperty.setOwner(createPropertyDTO.getOwner());
        existingProperty.setContact(createPropertyDTO.getContact());
        existingProperty.setDate(createPropertyDTO.getDate());
        return propertyRepository.save(existingProperty);
    }
}
