package com.example.mapping.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    private String empName;

    private String empDob;

    // Many employees can share the same address, so we use @ManyToOne
    @ManyToOne
    private Address address;

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDob() {
        return empDob;
    }

    public void setEmpDob(String empDob) {
        this.empDob = empDob;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


}

