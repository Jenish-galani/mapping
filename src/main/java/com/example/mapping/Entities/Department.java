package com.example.mapping.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deptId;

    private String deptName;

    private LocalDate deptStartDate;


    // Foreign key to Emp
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id")
    private Emp employee; // This will reference Emp entity

    public Long getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public LocalDate getDeptStartDate() {
        return deptStartDate;
    }

    public Emp getEmployee() {
        return employee;
    }
}

