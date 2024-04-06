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

}
