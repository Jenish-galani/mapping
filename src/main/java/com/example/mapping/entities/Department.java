package com.example.mapping.entities;

import jakarta.persistence.*;
import lombok.Data;

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
    private Employee employee; // This will reference Emp entity

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public LocalDate getDeptStartDate() {
        return deptStartDate;
    }

    public void setDeptStartDate(LocalDate deptStartDate) {
        this.deptStartDate = deptStartDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

