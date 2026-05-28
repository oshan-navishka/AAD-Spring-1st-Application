package com.ijse.aad_75.controller;

import com.ijse.aad_75.dto.DepartmentDTO;
import com.ijse.aad_75.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveDepartment(@RequestBody DepartmentDTO departmentDTO){
        departmentService.saveDepartment(departmentDTO);
        return "Department saved successfully";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllDepartments(){
        log.info("Execute methode getAllDepartments");
        return departmentService.getAllDepartments().toString();
    }
}
