package com.ijse.aad_75.service.impl;

import com.ijse.aad_75.dto.EmployeeDTO;
import com.ijse.aad_75.dto.Request.UpdateAddress;
import com.ijse.aad_75.entity.Employee;
import com.ijse.aad_75.enumaration.EmployeeStatus;
import com.ijse.aad_75.repository.EmployeeRepository;
import com.ijse.aad_75.service.EmployeeService;
//import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
//@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void saveEmployee(EmployeeDTO employeeDTO) {
        try {
            Employee employee = new Employee();
            employee.setFirstName(employeeDTO.getFirstName());
            employee.setLastName(employeeDTO.getLastName());
            employee.setAddress(employeeDTO.getAddress());
            employee.setJoinDate(LocalDate.now());

            employeeRepository.save(employee);
        } catch (Exception e) {
            log.error("Error while saving employee"+ e);
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
        } catch (Exception e) {
            log.error("Error while getting all employees"+ e);
            return null;
        }
    }

    @Override
    public EmployeeDTO getEmployeeDetails(long empId) {
        log.info("Execute method getEmployeeDetails(), empId: {}", empId);

        try{
            Optional<Employee> optionalEmployee = employeeRepository.findById(empId);

            if (optionalEmployee.isEmpty())
                throw new RuntimeException("Sorry, related employee is not found");

            Employee employee = optionalEmployee.get();
            EmployeeDTO responseData = new EmployeeDTO();
            responseData.setEmployeeId(employee.getEmployeeId());
            responseData.setFirstName(employee.getFirstName());
            responseData.setLastName(employee.getLastName());
            responseData.setAddress(employee.getAddress());
            responseData.setJoinDate(employee.getJoinDate());

            return responseData;

        }catch (Exception e){
            log.error("Error while getting employee details"+ e.getMessage());
            throw e;
        }
    }

    @Override
    public void updateEmployee(EmployeeDTO employeeDTO) {
        log.info("Execute method updateEmployee dto{}", employeeDTO);
        try{
            Optional<Employee> optionalEmployee = employeeRepository.findById(employeeDTO.getEmployeeId());

            if (optionalEmployee.isEmpty())
                throw new RuntimeException("Sorry, related employee is not found");

            Employee employee = optionalEmployee.get();

            employee.setFirstName(employeeDTO.getFirstName());
            employee.setLastName(employeeDTO.getLastName());
            employee.setAddress(employeeDTO.getAddress());

            employeeRepository.save(employee);
        }catch (Exception e){
            log.error("Error while updating employee"+ e.getMessage());
            throw e;
        }
    }

    @Override
    public void updateAddress(UpdateAddress updateAddress) {
        log.info("Execute method updateAddress dto{}", updateAddress);
        try{
            Optional<Employee> optionalEmployee = employeeRepository.findById(updateAddress.getEmployeeId());

            if (optionalEmployee.isEmpty())
                throw new RuntimeException("Sorry, related employee is not found");

            Employee employee = optionalEmployee.get();
            employee.setAddress(updateAddress.getAddress());

            employeeRepository.save(employee);
        }catch (Exception e){
            log.error("Error while updating employee address"+ e.getMessage());
        }
    }

    @Override
    public void changeEmployeeStatus(long empId) {
        log.info("Execute method changeEmployeeStatus, empId: {}", empId);
        try{
            Optional<Employee> optionalEmployee = employeeRepository.findById(empId);

            if (optionalEmployee.isEmpty())
                throw new RuntimeException("Sorry, related employee is not found");

            Employee employee = optionalEmployee.get();
            employee.setEmployeeStatus(EmployeeStatus.INACTIVE);

            employeeRepository.save(employee);
        }catch (Exception e){
            log.error("Error while changing employee status"+ e.getMessage());
            throw e;
        }
    }
}
