package com.ijse.aad_75.controller;

import com.ijse.aad_75.constant.CommonResponse;
import com.ijse.aad_75.dto.EmployeeDTO;
import com.ijse.aad_75.dto.Request.UpdateAddress;
import com.ijse.aad_75.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

import static com.ijse.aad_75.constant.ResponseConde.OPERATION_SUCCESS;
import static com.ijse.aad_75.constant.ResponseMassage.SUCCESS_MASSAGE;

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
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.saveEmployee(employeeDTO);
        return "Employee saved successfully";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeDTO> getAllEmployees() {
        log.info("Execute methode getAllEmployee");
        return employeeService.getAllEmployees();
    }

    @GetMapping(value = "/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getEmployeeDetails(@PathVariable long employeeId) { // udin ewana employee id eka allaganna use karana annotation eka thama @PathVariable kiyanne
        EmployeeDTO employeeDetails = employeeService.getEmployeeDetails(employeeId);

        return new CommonResponse(OPERATION_SUCCESS, employeeDetails, SUCCESS_MASSAGE);

    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.updateEmployee(employeeDTO);
        return new CommonResponse(OPERATION_SUCCESS, employeeDTO, SUCCESS_MASSAGE);
    }

    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse updateAddress(@RequestBody UpdateAddress dto) {
        employeeService.updateAddress(dto);
        return new CommonResponse(OPERATION_SUCCESS, dto, SUCCESS_MASSAGE);
    }
}
