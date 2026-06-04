package com.ijse.aad_75.service.impl;

import com.ijse.aad_75.dto.EmployeeDTO;
import com.ijse.aad_75.dto.StudentsDTO;
import com.ijse.aad_75.entity.Students;
import com.ijse.aad_75.repository.StudentsRepository;
import com.ijse.aad_75.service.StudentsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StudentsServiceImpl implements StudentsService {

    private final StudentsRepository studentsRepository;

    public StudentsServiceImpl(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Override
    public void saveStudents(StudentsDTO studentsDTO) {
        log.info("Execute method saveStudents");

        if (studentsDTO.getStudentFirstName() == null) {
            throw new RuntimeException("Student First Name is null");
        }

        try {
            Students students = new Students();
            students.setStudentFirstName(studentsDTO.getStudentFirstName());
            students.setStudentLastName(studentsDTO.getStudentLastName());
            students.setStudentContact(studentsDTO.getStudentContact());

            studentsRepository.save(students);
        }catch (Exception e){
            log.error("Error while saving Students", e);
        }
    }

    @Override
    public List<Students> getAllStudents() {
        try {
            log.info("Execute method getAllStudents");

            List<StudentsDTO> responseList = new ArrayList<>();
            List<Students> studentsList = studentsRepository.findAll();

            for (Students students : studentsList) {
                StudentsDTO studentsDTO = new StudentsDTO();
                studentsDTO.setStudentId(students.getStudentId());
                studentsDTO.setStudentFirstName(students.getStudentFirstName());
                studentsDTO.setStudentLastName(students.getStudentLastName());
                studentsDTO.setStudentContact(students.getStudentContact());

                responseList.add(studentsDTO);
            }
            return studentsList;
        }catch (Exception e){
            log.error("Error while fetching all students", e);
            return null;
        }
    }
}
