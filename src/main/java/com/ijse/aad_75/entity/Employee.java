package com.ijse.aad_75.entity;

import com.ijse.aad_75.enumaration.EmployeeStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;
    private String firstName;
    private String lastName;
    private String address;
    private LocalDate joinDate;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus;
}
