package com.example.mapping.Dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class DepartmentDTO {
    private Long deptId;
    private String deptName;
    private LocalDate deptStartDate;
    private String deptHeadName;
    private String deptHeadAddress;

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public LocalDate getDeptStartDate() {
        return deptStartDate;
    }

    public void setDeptStartDate(LocalDate deptStartDate) {
        this.deptStartDate = deptStartDate;
    }

    public String getDeptHeadName() {
        return deptHeadName;
    }

    public void setDeptHeadName(String deptHeadName) {
        this.deptHeadName = deptHeadName;
    }

    public String getDeptHeadAddress() {
        return deptHeadAddress;
    }

    public void setDeptHeadAddress(String deptHeadAddress) {
        this.deptHeadAddress = deptHeadAddress;
    }
}

