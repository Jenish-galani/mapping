package com.example.mapping.Controller;

import com.example.mapping.Dto.DepartmentDTO;
import com.example.mapping.Entities.Department;
import com.example.mapping.Services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api")
public class DepartCotroller {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/addDept")
    public Department addDept(@RequestBody Department department) {
        return departmentService.save(department);
    }

    @GetMapping("findById/{id}")
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

