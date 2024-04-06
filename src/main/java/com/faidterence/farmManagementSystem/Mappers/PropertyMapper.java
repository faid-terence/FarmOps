package com.faidterence.farmManagementSystem.Mappers;

import com.faidterence.farmManagementSystem.dto.CreatePropertyDTO;
import com.faidterence.farmManagementSystem.schema.Property;

public class PropertyMapper {

    public  static Property mapToProperty(CreatePropertyDTO createPropertyDTO){
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
        return property;
    }

    public static CreatePropertyDTO mapToCreatePropertyDTO(Property property){
        CreatePropertyDTO createPropertyDTO = new CreatePropertyDTO();
        createPropertyDTO.setName(property.getName());
        createPropertyDTO.setLocation(property.getLocation());
        createPropertyDTO.setDescription(property.getDescription());
        createPropertyDTO.setCategory(property.getCategory());
        createPropertyDTO.setStatus(property.getStatus());
        createPropertyDTO.setPrice(property.getPrice());
        createPropertyDTO.setQuantity(property.getQuantity());
        createPropertyDTO.setOwner(property.getOwner());
        createPropertyDTO.setContact(property.getContact());
        createPropertyDTO.setDate(property.getDate());
        return createPropertyDTO;
    }
}
