package com.faidterence.farmManagementSystem.controllers;


import com.faidterence.farmManagementSystem.dto.CreatePropertyDTO;
import com.faidterence.farmManagementSystem.schema.Property;
import com.faidterence.farmManagementSystem.services.PropertyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    private PropertyService propertyService;

    @PostMapping
    public ResponseEntity<CreatePropertyDTO> addProperty(@RequestBody CreatePropertyDTO createPropertyDTO) {
        Property savedProperty = propertyService.createProperty(createPropertyDTO);

        CreatePropertyDTO responseDto = new CreatePropertyDTO();
        responseDto.setName(savedProperty.getName());
        responseDto.setLocation(savedProperty.getLocation());
        responseDto.setDescription(savedProperty.getDescription());
        responseDto.setCategory(savedProperty.getCategory());
        responseDto.setStatus(savedProperty.getStatus());
        responseDto.setPrice(savedProperty.getPrice());
        responseDto.setQuantity(savedProperty.getQuantity());
        responseDto.setOwner(savedProperty.getOwner());
        responseDto.setContact(savedProperty.getContact());
        responseDto.setDate(savedProperty.getDate());

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
    @GetMapping
    public List<Property> getAllProperties() {
        return propertyService.getAllProperties();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
        Property property = propertyService.getPropertyById(id);
        return new ResponseEntity<>(property, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreatePropertyDTO> updateProperty(@PathVariable Long id, @RequestBody CreatePropertyDTO createPropertyDTO) {
        Property updatedProperty = propertyService.updateProperty(id, createPropertyDTO);

        CreatePropertyDTO responseDto = new CreatePropertyDTO();
        responseDto.setName(updatedProperty.getName());
        responseDto.setLocation(updatedProperty.getLocation());
        responseDto.setDescription(updatedProperty.getDescription());
        responseDto.setCategory(updatedProperty.getCategory());
        responseDto.setStatus(updatedProperty.getStatus());
        responseDto.setPrice(updatedProperty.getPrice());
        responseDto.setQuantity(updatedProperty.getQuantity());
        responseDto.setOwner(updatedProperty.getOwner());
        responseDto.setContact(updatedProperty.getContact());
        responseDto.setDate(updatedProperty.getDate());

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}
