package com.example.mapping.controllers;

import com.example.mapping.entities.Emp;
import com.example.mapping.services.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmpController {
    @Autowired
    private EmpService empService;


    @PostMapping("/employee")
    public Emp createEmployee(@RequestBody Emp employee) {
        return empService.saveEmployee(employee);
    }

    @GetMapping("findByID/{id}")
    public Optional<Emp> findById(@PathVariable Long id) {
        return empService.show(id);
    }
}


