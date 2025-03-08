package com.example.mapping.Services;

import com.example.mapping.Dto.DepartmentDTO;
import com.example.mapping.Entities.Address;
import com.example.mapping.Entities.Department;
import com.example.mapping.Entities.Emp;
import com.example.mapping.Repositories.DeptRepo;
import com.example.mapping.Repositories.EmpRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DeptRepo departmentRepository;

    @Autowired
    private EmpRepo empRepo;

    public Department saveDepartment(Department department) {
        // Check if the employee exists
        Emp emp = empRepo.findById(department.getEmployee().getEmpId()).orElse(null);

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

    public Optional<Department> findById(Long id) {
        return departmentRepository.findById(id);
    }

    @Transactional
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

