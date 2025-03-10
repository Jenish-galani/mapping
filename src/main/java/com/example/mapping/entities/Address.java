package com.example.mapping.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    private String addressLine;

    private String city;

    private String state;

    private int pincode;
}
