package com.example.mapping.Controller;

import com.example.mapping.Entities.Address;
import com.example.mapping.Entities.Emp;
import com.example.mapping.Services.AddServ;
import com.example.mapping.Services.EmpService;
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


