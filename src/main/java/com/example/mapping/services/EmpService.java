package com.example.mapping.services;

import com.example.mapping.entities.Emp;

import java.util.Optional;

public interface EmpService {
    Emp saveEmployee(Emp employee);
    Optional<Emp> show(Long id);
}
