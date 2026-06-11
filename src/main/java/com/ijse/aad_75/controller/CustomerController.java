package com.ijse.aad_75.controller;

import com.ijse.aad_75.constant.CommonResponse;
import com.ijse.aad_75.dto.CustomerDTO;
import com.ijse.aad_75.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ijse.aad_75.constant.ResponseConde.OPERATION_SUCCESS;
import static com.ijse.aad_75.constant.ResponseMassage.SUCCESS_MASSAGE;

@RestController
@RequestMapping("v1/customers")
@Slf4j
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        return new CommonResponse(OPERATION_SUCCESS, SUCCESS_MASSAGE);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getAllCustomers(){
        log.info("Execute methode getAllCustomersByName");
        return new CommonResponse(OPERATION_SUCCESS, customerService.getAllCustomers(), SUCCESS_MASSAGE);
    }

    @GetMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse findById(
            @RequestParam(value = "customerName", required = false) Long customerId){
        List<CustomerDTO> customerDTOS = customerService.findById(customerId);
        return new CommonResponse(OPERATION_SUCCESS, customerDTOS, SUCCESS_MASSAGE);
    }

    @GetMapping(value = "/names", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getAllCustomerNames() {

        List<String> customerNames = customerService.getAllCustomersNames();

        return new CommonResponse(
                OPERATION_SUCCESS,
                customerNames,
                SUCCESS_MASSAGE
        );
    }
}
