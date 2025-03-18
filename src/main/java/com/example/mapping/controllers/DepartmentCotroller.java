package com.example.mapping.controllers;

import com.example.mapping.dto.DepartmentDTO;
import com.example.mapping.entities.Department;
import com.example.mapping.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api")
public class DepartmentCotroller {
    @Autowired
    private DepartmentService departmentService; //jenish

    @PostMapping("/saveDepartment")
    public Department addDept(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("findDepartmentById/{id}")
    public Optional<Department> findById(@PathVariable Long id) {
        return departmentService.findById(id);
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentDTOById(@PathVariable Long id) {
        DepartmentDTO departmentDTO = departmentService.getDepartmentDTOById(id);
        if (departmentDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(departmentDTO);
    }
}

