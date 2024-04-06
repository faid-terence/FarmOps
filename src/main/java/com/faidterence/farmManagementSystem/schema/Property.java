package com.faidterence.farmManagementSystem.schema;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "properties")

public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column()
private String name;
    @Column()
private String location;
    @Column()
private String description;
    @Column()
private String category;
    @Column()
private String status;
    @Column()
private String price;
    @Column()
private String quantity;
    @Column()
private String owner;
    @Column()
private String contact;
    @Column()
private String date;



}
