package com.faidterence.farmManagementSystem.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CreatePropertyDTO {

    private String name;
    private String location;
    private String description;
    private String category;
    private String status;
    private String price;
    private String quantity;
    private String owner;
    private String contact;
    private String date;

}
