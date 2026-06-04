package com.ijse.aad_75.service;

import com.ijse.aad_75.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    void saveDepartment(DepartmentDTO departmentDTO);

    List<DepartmentDTO> getAllDepartments();

    DepartmentDTO getDepartmentDetails(long departmentId);
}
