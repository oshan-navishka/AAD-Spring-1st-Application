package com.ijse.aad_75.repository;

import com.ijse.aad_75.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "SELECT * FROM employee WHERE (?1 IS NULL OR firstName LIKE %?1%) AND "
            + "(?2 IS NULL OR lastName LIKE %?2%)", nativeQuery = true)
    List<Employee>filterEmployee(String firstName,String address);
}
