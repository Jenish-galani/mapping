package com.example.mapping.services;

import com.example.mapping.entities.Emp;
import com.example.mapping.repositories.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    private EmpRepo empRepository;

    public Emp save(Emp emp) {
        return empRepository.save(emp);
    }
}

