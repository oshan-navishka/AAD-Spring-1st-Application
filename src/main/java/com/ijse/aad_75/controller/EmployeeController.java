package com.ijse.aad_75.controller;

import com.ijse.aad_75.dto.EmployeeDTO;
import com.ijse.aad_75.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

//@Controller
//@ResponseBody
@Slf4j
@RestController
@RequestMapping(value = "v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        employeeService.saveEmployee(employeeDTO);
        return "Employee saved successfully";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeDTO> getAllEmployees(){
        log.info("Execute methode getAllEmployee");
        return employeeService.getAllEmployees();
    }
}
