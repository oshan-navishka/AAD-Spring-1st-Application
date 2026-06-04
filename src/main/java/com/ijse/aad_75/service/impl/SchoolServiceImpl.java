package com.ijse.aad_75.service.impl;

import com.ijse.aad_75.dto.SchoolDTO;
import com.ijse.aad_75.entity.School;
import com.ijse.aad_75.repository.SchoolRepository;
import com.ijse.aad_75.service.SchoolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public void saveSchool(SchoolDTO schoolDTO) {
        log.info("Execute method saveSchool");

        if (schoolDTO.getSchool_Name() == null) {
            throw new RuntimeException("School Name is null");
        }

        try {
            School school = new School();
            school.setSchool_Name(schoolDTO.getSchool_Name());
            school.setSchool_location(schoolDTO.getSchool_location());

            schoolRepository.save(school);
        }catch (Exception e){
            log.error("Error while saving Students", e);
        }
    }

    @Override
    public List<School> getAllSchools() {
        try {
            log.info("Execute method getAllSchools");

            List<SchoolDTO> responseList = new ArrayList<>();
            List<School> schoolList = schoolRepository.findAll();

            for (School school : schoolList) {
                SchoolDTO schoolDTO = new SchoolDTO();
                schoolDTO.setSchool_Id(school.getSchool_Id());
                schoolDTO.setSchool_Name(school.getSchool_Name());
                schoolDTO.setSchool_location(school.getSchool_location());

                responseList.add(schoolDTO);
            }
            return schoolList;
        }catch (Exception e){
            log.error("Error while fetching all schools", e);
            return null;
        }
    }
}
