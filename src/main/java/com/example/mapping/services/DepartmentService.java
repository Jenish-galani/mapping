package com.example.mapping.services;

import com.example.mapping.dto.DepartmentDTO;
import com.example.mapping.entities.Department;

import java.util.Optional;

public interface DepartmentService {
    Department saveDepartment(Department department);
    Optional<Department> findById(Long id);
    DepartmentDTO getDepartmentDTOById(Long deptId);
}
