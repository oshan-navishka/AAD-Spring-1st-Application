package com.ijse.aad_75.controller;

import com.ijse.aad_75.constant.CommonResponse;
import com.ijse.aad_75.dto.DepartmentDTO;
import com.ijse.aad_75.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.ijse.aad_75.constant.ResponseConde.OPERATION_SUCCESS;
import static com.ijse.aad_75.constant.ResponseMassage.SUCCESS_MASSAGE;

@Slf4j
@RestController
@RequestMapping("v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse saveDepartment(@RequestBody DepartmentDTO departmentDTO){
        departmentService.saveDepartment(departmentDTO);
        return new CommonResponse(OPERATION_SUCCESS, SUCCESS_MASSAGE);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getAllDepartments(){
        log.info("Execute methode getAllDepartments");
        return new CommonResponse(OPERATION_SUCCESS, departmentService.getAllDepartments(), SUCCESS_MASSAGE);
    }

    @GetMapping(value = "/{departmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getDepartmentDetails(@PathVariable long departmentId){
        DepartmentDTO departmentDetails = departmentService.getDepartmentDetails(departmentId);

        return new CommonResponse(OPERATION_SUCCESS, departmentDetails, SUCCESS_MASSAGE);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse updateDepartment(@RequestBody DepartmentDTO departmentDTO){
        departmentService.updateDepartment(departmentDTO);
        return new CommonResponse(OPERATION_SUCCESS, SUCCESS_MASSAGE);
    }
}
