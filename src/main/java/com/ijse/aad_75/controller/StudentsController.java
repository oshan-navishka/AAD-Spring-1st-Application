package com.ijse.aad_75.controller;

import com.ijse.aad_75.constant.CommonResponse;
import com.ijse.aad_75.dto.StudentsDTO;
import com.ijse.aad_75.service.StudentsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.ijse.aad_75.constant.ResponseConde.OPERATION_SUCCESS;
import static com.ijse.aad_75.constant.ResponseMassage.SUCCESS_MASSAGE;


@RestController
@RequestMapping("v1/students")
public class StudentsController {
    private final StudentsService studentsService;

    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse saveStudents(@RequestBody StudentsDTO studentsDTO){
        studentsService.saveStudents(studentsDTO);
//        return "Students saved successfully";
        return new CommonResponse(OPERATION_SUCCESS, "Students Saved..");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getAllStudents(){
//        return studentsService.getAllStudents().toString();
        return new CommonResponse(OPERATION_SUCCESS, studentsService.getAllStudents(), SUCCESS_MASSAGE);
    }
}
