package com.ijse.aad_75.service.impl;

import com.ijse.aad_75.dto.CustomerDTO;
import com.ijse.aad_75.entity.Customer;
import com.ijse.aad_75.repository.CustomerRepository;
import com.ijse.aad_75.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        log.info("Execute method saveCustomer");

        if (customerDTO.getCustomerName() == null) {
            throw new RuntimeException("Customer Name is null");
        }
        try{
            Customer customer = new Customer();
            customer.setCustomerName(customerDTO.getCustomerName());
            customer.setCustomerAddress(customerDTO.getCustomerAddress());
            customerRepository.save(customer);
        }catch (Exception e){
            log.error("Error while saving Customer"+ e.getMessage());
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        log.info("Execute method getAllCustomers");
        try{
            List<CustomerDTO> responsList = new ArrayList<>();
            List<Customer> customerList = customerRepository.findAll();

            for (Customer customer : customerList) {
                CustomerDTO customerDTO = new CustomerDTO();
                customerDTO.setCustomerName(customer.getCustomerName());
                responsList.add(customerDTO);
            }
            return responsList;
        }catch (Exception e){
            log.error("Error while fetching all customers"+ e.getMessage());
            return null;
        }
    }

    @Override
    public List<CustomerDTO> findById(Long customerId) {
        log.info("Execute method getSingleCustomer, customerName: {}", customerId);
        try{
            List<Customer> customerList = customerRepository.findAll();

            for (Customer customer : customerList) {
                if (customer.getCustomerName().equals(customerId)) {
                    CustomerDTO customerDTO = new CustomerDTO();
                    customerDTO.setCustomerId(customer.getCustomerId());
                    customerDTO.setCustomerName(customer.getCustomerName());
                    customerDTO.setCustomerAddress(customer.getCustomerAddress());
                    log.info("Customer details: {}", customerDTO);
                }
            }
        }catch (Exception e){
            log.error("Error while fetching single customer"+ e.getMessage());
        }
        return null;
    }

    @Override
    public List<String> getAllCustomersNames() {
        log.info("Execute method getAllCustomersNames");

        try {
            return customerRepository.getAllCustomerNames();
        }catch (Exception e){
            log.error("Error while fetching all customers names"+ e.getMessage());
            return null;
        }
    }

}
