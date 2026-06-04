package com.ijse.aad_75.service;

import com.ijse.aad_75.dto.DepartmentDTO;
import com.ijse.aad_75.dto.Request.UpdateDepartmentDTO;

import java.util.List;

public interface DepartmentService {

    void saveDepartment(DepartmentDTO departmentDTO);

    List<DepartmentDTO> getAllDepartments();

    DepartmentDTO getDepartmentDetails(long departmentId);

    void updateDepartment(DepartmentDTO departmentDTO);

    void updateLocation(UpdateDepartmentDTO updateDepartmentDTO);

    List<DepartmentDTO> filterDepartment(String departmentName, String DepartmentLocation);
}
