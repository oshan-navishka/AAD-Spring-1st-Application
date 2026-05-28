package com.ijse.aad_75.controller;

import com.ijse.aad_75.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveDepartment(){
        departmentService.saveDepartment();
        return "Department saved successfully";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllDepartments(){
        log.info("Execute methode getAllDepartments");
        return departmentService.getAllDepartments().toString();
    }
}
