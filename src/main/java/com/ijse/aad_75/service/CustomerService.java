package com.ijse.aad_75.service;

import com.ijse.aad_75.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> getAllCustomers();

    List<CustomerDTO>findById(Long customerId);

    List<String> getAllCustomersNames();

}
