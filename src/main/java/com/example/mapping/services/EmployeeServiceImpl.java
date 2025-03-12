package com.example.mapping.services;

import com.example.mapping.entities.Address;
import com.example.mapping.entities.Employee;
import com.example.mapping.repositories.AddressRepository;
import com.example.mapping.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository empRepository;

    @Autowired
    private AddressRepository addRepo;


    @Override
    public Employee saveEmployee(Employee employee) {
        // Check if address exists and assign it to the employee
        Address address = addRepo.findById(employee.getAddress().getAddressId()).orElse(null);

        if (address != null) {
            employee.setAddress(address); // Set the found address to the employee
        } else {
            System.out.println("Address not found for ID: " + employee.getAddress().getAddressId());
            // Handle address not found case if necessary, maybe throw an exception
            throw new RuntimeException("Address not found for ID: " + employee.getAddress().getAddressId());
        }

        return empRepository.save(employee);
    }

    @Override
    public Optional<Employee> show(Long id) {
        return empRepository.findById(id);
    }

    @Override
    public Employee findByEmpName(String empName) {
        return empRepository.findByEmpName(empName);
    }

}

