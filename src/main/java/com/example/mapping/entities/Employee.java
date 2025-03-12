package com.example.mapping.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    private String empName;

    private String empDob;

    // Many employees can share the same address, so we use @ManyToOne
    @ManyToOne
    private Address address;


}

