package com.ijse.aad_75.service;

import com.ijse.aad_75.dto.SchoolDTO;
import com.ijse.aad_75.entity.School;

import java.util.List;

public interface SchoolService {
    void saveSchool(SchoolDTO schoolDTO);

    List<School> getAllSchools();
}
