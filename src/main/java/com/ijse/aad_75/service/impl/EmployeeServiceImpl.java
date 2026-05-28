package com.ijse.aad_75.service.impl;

import com.ijse.aad_75.dto.EmployeeDTO;
import com.ijse.aad_75.entity.Employee;
import com.ijse.aad_75.repository.EmployeeRepository;
import com.ijse.aad_75.service.EmployeeService;
//import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
//@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void saveEmployee(){
        try{
            Employee employee = new Employee();
            employee.setFirstName("Oshan");
            employee.setLastName("Navishka");
            employee.setAddress("Rathnapura");
            employee.setJoinDate(LocalDate.now());

            employeeRepository.save(employee);
        }catch (Exception e){
            log.error("Error while saving employee", e);
        }
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {

        try {
            log.info("Execute methode getAllEmployee");

            List<EmployeeDTO> responseList = new ArrayList<>();

            List<Employee> employeeList = employeeRepository.findAll();

            for (Employee employee : employeeList) {
                EmployeeDTO employeeDTO = new EmployeeDTO();
                employeeDTO.setEmployeeId(employee.getEmployeeId());
                employeeDTO.setFirstName(employee.getFirstName());
                employeeDTO.setLastName(employee.getLastName());

                responseList.add(employeeDTO);
            }
            return responseList;
        }catch (Exception e){
            log.error("Error while getting all employees", e);
            return null;
        }
    }
}
