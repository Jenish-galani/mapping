package com.example.mapping.Services;

import com.example.mapping.Dto.DepartmentDTO;
import com.example.mapping.Entities.Department;
import com.example.mapping.Repositories.DeptRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DeptRepo departmentRepository;

    public Department save(Department department) {
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

