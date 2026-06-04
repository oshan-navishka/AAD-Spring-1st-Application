package com.ijse.aad_75.controller;

import com.ijse.aad_75.dto.SchoolDTO;
import com.ijse.aad_75.dto.StudentsDTO;
import com.ijse.aad_75.service.SchoolService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/schools")
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveSchool(@RequestBody SchoolDTO schoolDTO){
        schoolService.saveSchool(schoolDTO);
        return "School saved successfully";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllSchools(){
        return schoolService.getAllSchools().toString();
    }
}
