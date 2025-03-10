package com.example.mapping.services;

import com.example.mapping.entities.Employee;

import java.util.Optional;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    Optional<Employee> show(Long id);
    Employee findByEmpName(String empName); // ✅ Match the exact field name in Employee entity
}
