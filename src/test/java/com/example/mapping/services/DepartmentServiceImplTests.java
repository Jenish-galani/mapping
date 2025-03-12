package com.example.mapping.services;

import com.example.mapping.dto.DepartmentDTO;
import com.example.mapping.entities.Address;
import com.example.mapping.entities.Department;
import com.example.mapping.entities.Employee;
import com.example.mapping.repositories.DepartmentRepository;
import com.example.mapping.repositories.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.elasticsearch.core.index.AliasAction;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTests {
    @Mock
    private DepartmentRepository departmentRepository;

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private DepartmentServiceImpl departmentService;


    @Test
    public void saveDepartmentTestTrue() {
        Employee employee = new Employee();
        employee.setEmpId(1L);
        employee.setEmpName("Test");

        Department department = new Department();
        department.setDeptId(1L);
        department.setEmployee(employee); // Set employee

        // Mocking
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        when(departmentRepository.save(Mockito.any(Department.class))).thenReturn(department);

        Department result = departmentService.saveDepartment(department);

        // Assertion
        Assertions.assertNotNull(result);
        Assertions.assertEquals(employee, result.getEmployee());
    }

    @Test
    public void saveDepartmentTestFalse() {
        Employee employee = new Employee();
        employee.setEmpId(1L);

        Department department = new Department();
        department.setDeptId(1L);
        department.setEmployee(employee); // Set employee

        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            departmentService.saveDepartment(department);
        });

        // Ensure the correct error message is asserted
        Assertions.assertEquals("Employee not found for ID: 1", exception.getMessage());
    }



    @Test
    public void findByIdTest() {
        Optional<Department> department = Optional.of(new Department());
        when(departmentRepository.findById(1L)).thenReturn(department);
        Optional<Department> result = departmentService.findById(1L);
        assertEquals(department, result);
    }

    @Test
    public void getDepartmentDTOByIdTest() {
        Address address = new Address();
        address.setAddressLine("123 Main St");

        Employee employee = new Employee();
        employee.setEmpName("John Doe");
        employee.setAddress(address);

        Department department = new Department();
        department.setDeptId(1L);
        department.setDeptName("IT");
        department.setDeptStartDate(LocalDate.of(2018, 1, 1));
        department.setEmployee(employee);

        when(departmentRepository.findByIdWithEmployeeAndAddress(1L)).thenReturn(department);

        DepartmentDTO result = departmentService.getDepartmentDTOById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getDeptId());
        assertEquals("IT", result.getDeptName());
        assertEquals(LocalDate.of(2018, 1, 1), department.getDeptStartDate());
        assertEquals("John Doe", result.getDeptHeadName());
        assertEquals("123 Main St", result.getDeptHeadAddress());
    }

}
