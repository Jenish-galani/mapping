package com.example.mapping.services;

import com.example.mapping.dto.DepartmentDTO;
import com.example.mapping.entities.Department;
import com.example.mapping.entities.Employee;
import com.example.mapping.repositories.DepartmentRepository;
import com.example.mapping.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository empRepo;

    @Override
    public Department saveDepartment(Department department) {
        // Check if the employee exists
        Employee emp = empRepo.findById(department.getEmployee().getEmpId()).orElse(null);

        if (emp != null) {
            // If the employee exists, associate it with the department
            department.setEmployee(emp);
        } else {
            // Handle the case where the employee doesn't exist
            throw new RuntimeException("Employee not found for ID: " + department.getEmployee().getEmpId());
        }

        // Save the department to the database
        return departmentRepository.save(department);
    }

    @Override
    public Optional<Department> findById(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public DepartmentDTO getDepartmentDTOById(Long deptId) {
        // Fetch only the necessary fields (department with employee and address)
        Department department = departmentRepository.findByIdWithEmployeeAndAddress(deptId);

        // Map entity to DTO
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setDeptId(department.getDeptId());
        departmentDTO.setDeptName(department.getDeptName());
        departmentDTO.setDeptStartDate(department.getDeptStartDate());

        // Set only the short employee name and address
        departmentDTO.setDeptHeadName(department.getEmployee().getEmpName()); // Short name
        departmentDTO.setDeptHeadAddress(department.getEmployee().getAddress().getAddressLine()); // Short address

        return departmentDTO;
    }
}

