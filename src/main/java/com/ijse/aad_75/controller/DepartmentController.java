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
    public String saveDepartment(@RequestBody DepartmentDTO departmentDTO){
        departmentService.saveDepartment(departmentDTO);
        return "Department saved successfully";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllDepartments(){
        log.info("Execute methode getAllDepartments");
        return departmentService.getAllDepartments().toString();
    }

    @GetMapping(value = "/{departmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getDepartmentDetails(@PathVariable long departmentId){
        DepartmentDTO departmentDetails = departmentService.getDepartmentDetails(departmentId);

        return new CommonResponse(OPERATION_SUCCESS, departmentDetails, SUCCESS_MASSAGE);
    }
}
