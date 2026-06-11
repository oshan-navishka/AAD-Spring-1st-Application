package com.ijse.aad_75.repository;

import com.ijse.aad_75.dto.CustomerDTO;
import com.ijse.aad_75.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query("SELECT c.customerName FROM Customer c")
    List<String> getAllCustomerNames();
}
