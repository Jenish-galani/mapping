package com.example.mapping.repositories;

import com.example.mapping.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query("SELECT d FROM Department d LEFT JOIN FETCH d.employee e LEFT JOIN FETCH e.address WHERE d.deptId = :deptId")
    Department findByIdWithEmployeeAndAddress(@Param("deptId") Long deptId);
}

