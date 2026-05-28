package com.ijse.aad_75.dto;

import lombok.Data;


@Data
public class EmployeeDTO {
    private long employeeId;
    private String firstName;
    private String lastName;
    private String address;
    private String joinDate;
}
