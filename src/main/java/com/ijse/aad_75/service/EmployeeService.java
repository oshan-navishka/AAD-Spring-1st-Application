package com.ijse.aad_75.service;

import com.ijse.aad_75.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    void saveEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployees();

}
