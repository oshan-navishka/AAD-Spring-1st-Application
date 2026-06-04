package com.ijse.aad_75.service.impl;

import com.ijse.aad_75.dto.DepartmentDTO;
import com.ijse.aad_75.entity.Department;
import com.ijse.aad_75.repository.DepartmentRepository;
import com.ijse.aad_75.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService{
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public void saveDepartment(DepartmentDTO departmentDTO){
        try{
            Department department = new Department();
            department.setDepartment_Name(departmentDTO.getDepartment_Name());
            department.setDepartment_location(departmentDTO.getDepartment_location());

            departmentRepository.save(department);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        try{
           List<DepartmentDTO> responseList = new ArrayList<>();
           List<Department> departmentList = departmentRepository.findAll();

           for (Department department : departmentList) {
               DepartmentDTO departmentDTO = new DepartmentDTO();
               departmentDTO.setDepartment_Id(department.getDepartment_Id());
               departmentDTO.setDepartment_Name(department.getDepartment_Name());
               departmentDTO.setDepartment_location(department.getDepartment_location());

               responseList.add(departmentDTO);
           }
           return responseList;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public DepartmentDTO getDepartmentDetails(long departmentId) {
        log.info("Execute method getEmployeeDetails(), depId: {}", departmentId);

        try{
            Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);

            if (optionalDepartment.isEmpty())
                throw new RuntimeException("Sorry, related department is not found");

            Department department = optionalDepartment.get();

            DepartmentDTO responseData = new DepartmentDTO();
            responseData.setDepartment_Id(department.getDepartment_Id());
            responseData.setDepartment_Name(department.getDepartment_Name());
            responseData.setDepartment_location(department.getDepartment_location());

            return responseData;
        }catch (Exception e){
            log.error("Error while getting department details"+ e.getMessage());
            throw e;
        }
    }

    @Override
    public void updateDepartment(DepartmentDTO departmentDTO) {
        log.info("Execute method updateDepartment dto{}", departmentDTO);
        try{
            Optional<Department> optionalDepartment = departmentRepository.findById(departmentDTO.getDepartment_Id());

            if (optionalDepartment.isEmpty())
                throw new RuntimeException("Sorry, related department is not found");

            Department department = optionalDepartment.get();
            department.setDepartment_Name(departmentDTO.getDepartment_Name());
            department.setDepartment_location(departmentDTO.getDepartment_location());

            departmentRepository.save(department);
        }catch (Exception e){
            log.error("Error while updating department"+ e.getMessage());
            throw e;
        }
    }

}
