package com.example.mapping.services;

import com.example.mapping.entities.Address;
import com.example.mapping.entities.Emp;
import com.example.mapping.repositories.AddRepo;
import com.example.mapping.repositories.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpServiceImpl implements EmpService{
    @Autowired
    private EmpRepo empRepository;

    @Autowired
    private AddRepo addRepo;


    @Override
    public Emp saveEmployee(Emp employee) {
        // Check if address exists and assign it to the employee
        Address address = addRepo.findById(employee.getAddress().getAddressId()).orElse(null);

        if (address != null) {
            employee.setAddress(address); // Set the found address to the employee
        } else {
            // Handle address not found case if necessary, maybe throw an exception
            throw new RuntimeException("Address not found for ID: " + employee.getAddress().getAddressId());
        }

        return empRepository.save(employee);
    }

    @Override
    public Optional<Emp> show(Long id) {
        return empRepository.findById(id);
    }
}

