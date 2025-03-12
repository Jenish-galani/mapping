package com.example.mapping.services;

import com.example.mapping.entities.Address;
import com.example.mapping.entities.Employee;
import com.example.mapping.repositories.AddressRepository;
import com.example.mapping.repositories.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTests {

    @Mock
    private EmployeeRepository empRepository;

    @Mock
    private AddressRepository addRepo;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    public void saveEmployeeTestTrue() {
        Address address = new Address();
        address.setAddressLine("7");
        address.setAddressId(1L);

        Employee employee = new Employee();
        employee.setEmpName("test");
        employee.setEmpDob("2004-04-04");
        employee.setAddress(address);

        when(empRepository.save(employee)).thenReturn(employee);
        when(addRepo.findById(1L)).thenReturn(java.util.Optional.of(address));
        Employee result = employeeService.saveEmployee(employee);

        Assertions.assertEquals(result.getAddress(), address);

    }

    @Test
    public void saveEmployeeTestFalse() {
        Address address = new Address();
        address.setAddressId(1L);

        Employee employee = new Employee();
        employee.setEmpName("Test");
        employee.setEmpDob("2004-04-04");
        employee.setAddress(address);

        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            employeeService.saveEmployee(employee);
        });

        Assertions.assertEquals("Address not found for ID: 1", exception.getMessage());
    }

    @Test
    public void findByEmpNameTest() {
        Employee employee = new Employee();
        when(empRepository.findByEmpName("test")).thenReturn(employee);
        Employee result = employeeService.findByEmpName("test");
        Assertions.assertEquals(result, employee);
    }

    @Test
    public void showTest() {
        Optional<Employee> emp = Optional.of(new Employee());
        when(empRepository.findById(1L)).thenReturn(emp);
        Optional<Employee> result = employeeService.show(1L);
        Assertions.assertEquals(result, emp);
    }
}
