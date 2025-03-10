package com.example.mapping.services;

import com.example.mapping.entities.Department;
import com.example.mapping.repositories.DepartmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DepartmentServiceImplTests {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void DepartmentFindById() {
        Long testId = 4L;
        Optional<Department> department = departmentRepository.findById(testId);
        assertTrue(department.isPresent(), "Department with id : " + testId + "should exist");
    }
}
