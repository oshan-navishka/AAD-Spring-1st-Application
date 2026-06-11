package com.ijse.aad_75.service.impl;

import com.ijse.aad_75.dto.EmployeeDTO;
import com.ijse.aad_75.dto.StudentsDTO;
import com.ijse.aad_75.entity.School;
import com.ijse.aad_75.entity.Students;
import com.ijse.aad_75.repository.SchoolRepository;
import com.ijse.aad_75.repository.StudentsRepository;
import com.ijse.aad_75.service.StudentsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentsServiceImpl implements StudentsService {

    private final StudentsRepository studentsRepository;
    private final SchoolRepository schoolRepository;

    public StudentsServiceImpl(StudentsRepository studentsRepository, SchoolRepository schoolRepository) {
        this.studentsRepository = studentsRepository;
        this.schoolRepository = schoolRepository;
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

            Optional<School> optionalStudents = schoolRepository.findById(studentsDTO.getSchoolId());
            if (optionalStudents.isEmpty())
                throw new RuntimeException("Sorry, related student is already exist");
            School school = optionalStudents.get();
            students.setSchool(school);
            studentsRepository.save(students);
        }catch (Exception e){
            log.error("Error while saving Students"+ e.getMessage());
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
            log.error("Error while fetching all students"+ e.getMessage());
            return null;
        }
    }

    @Override
    public StudentsDTO getStudentDetails(long studentId) {
        log.info("Execute method getStudentDetails(), studentId: {}", studentId);

        try{
            Optional<Students> optionalStudents = studentsRepository.findById(studentId);
            if (optionalStudents.isEmpty())
                throw new RuntimeException("Sorry, related student is not found");

            Students students = optionalStudents.get();

            StudentsDTO responseData = new StudentsDTO();
            responseData.setStudentId(students.getStudentId());
            responseData.setStudentFirstName(students.getStudentFirstName());
            responseData.setStudentLastName(students.getStudentLastName());
            responseData.setStudentContact(students.getStudentContact());

            return responseData;
        }catch (Exception e){
            log.error("Error while getting student details" + e.getMessage());
            throw e;
        }
    }
}
