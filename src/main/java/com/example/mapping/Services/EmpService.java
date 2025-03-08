package com.example.mapping.Services;

import com.example.mapping.Entities.Emp;
import com.example.mapping.Repositories.EmpRepo;
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

