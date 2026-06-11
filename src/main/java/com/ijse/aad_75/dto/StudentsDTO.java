package com.ijse.aad_75.dto;

import lombok.Data;

@Data
public class StudentsDTO {
    private long studentId;
    private String studentFirstName;
    private String studentLastName;
    private String studentContact;

    private long schoolId;
}
