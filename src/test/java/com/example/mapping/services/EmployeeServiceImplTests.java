package com.example.mapping.services;

import com.example.mapping.entities.Employee;
import com.example.mapping.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployeeServiceImplTests {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void employeeFindByIdTest() {
        Long testEmployeeId = 3L;
        Optional<Employee> employee = employeeRepository.findById(testEmployeeId);
        assertTrue(employee.isPresent(), "Employee with id : " + testEmployeeId + "should exist");
    }

    @Test
    public void employeeFindByNametests() {
        String empName = "Meet Savliya1";
        Optional<Employee> employee = Optional.ofNullable(employeeRepository.findByEmpName(empName));
        assertTrue(employee.isPresent());
    }
}
