package com.example.mapping.Controller;

import com.example.mapping.Entities.Emp;
import com.example.mapping.Services.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmpController {

    @Autowired
    private EmpService empService;

    // Update the method to accept the employee data as a JSON object in the request body
    @PostMapping("/add")
    public Emp addEmployee(@RequestBody Emp emp) {
        return empService.save(emp);
    }
}


