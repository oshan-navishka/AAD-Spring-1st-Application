package com.ijse.aad_75.service.impl;

import com.ijse.aad_75.dto.DepartmentDTO;
import com.ijse.aad_75.entity.Department;
import com.ijse.aad_75.repository.DepartmentRepository;
import com.ijse.aad_75.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public void saveDepartment(){
        try{
            Department department = new Department();
            department.setDepartment_Name("IT");
            department.setDepartment_location("Dhaka");

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

}
