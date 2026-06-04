package com.ijse.aad_75.service;

import com.ijse.aad_75.dto.EmployeeDTO;
import com.ijse.aad_75.dto.Request.UpdateAddress;

import java.util.List;

public interface EmployeeService {

    void saveEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeDetails(long empId);

    void updateEmployee(EmployeeDTO employeeDTO);

    void updateAddress(UpdateAddress updateAddress);
}
