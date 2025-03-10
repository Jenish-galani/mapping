package com.example.mapping.repositories;

import com.example.mapping.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmpName(String empName); // ✅ Match the exact field name in Employee entity
}

