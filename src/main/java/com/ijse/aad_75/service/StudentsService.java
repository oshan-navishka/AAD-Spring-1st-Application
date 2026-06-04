package com.ijse.aad_75.service;

import com.ijse.aad_75.dto.StudentsDTO;
import com.ijse.aad_75.entity.Students;

import java.util.List;

public interface StudentsService {
    void saveStudents(StudentsDTO studentsDTO);

    List<Students> getAllStudents();

    StudentsDTO getStudentDetails(long studentId);
}
