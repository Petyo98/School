package com.example.school.service;


import com.example.school.jpa.School;

import java.util.List;

public interface SchoolService {

    School save(School school);

    void delete(Long schoolId);

    School getSchoolById(Long id);

    List<School> findAll();

}
