package com.ijse.aad_75.repository;

import com.ijse.aad_75.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    @Query(value = "SELECT * FROM department WHERE (?1 IS NULL OR department_name LIKE %?1%) AND "
            + "(?2 IS NULL OR department_Location LIKE %?2%)", nativeQuery = true)  // error pennane Like eke depaththe DB eka connect krala nathi nisa eke aulak na

    List<Department> filterDepartments(String departmentName, String departmentLocation);
}
