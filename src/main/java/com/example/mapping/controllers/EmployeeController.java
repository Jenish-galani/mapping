package com.example.mapping.controllers;

import com.example.mapping.entities.Employee;
import com.example.mapping.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService empService;


    @PostMapping("/saveEmployee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return empService.saveEmployee(employee);
    }

    @GetMapping("findEmployeeByID/{id}")
    public Optional<Employee> findById(@PathVariable Long id) {
        return empService.show(id);
    }

    @GetMapping("/findEmployeeByName/{empName}")
    public Employee findByName(@PathVariable String empName) {
        return empService.findByEmpName(empName);
    }
}


