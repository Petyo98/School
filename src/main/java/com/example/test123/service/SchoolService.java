package com.example.test123.service;


import com.example.test123.jpa.School;

import java.util.List;

public interface SchoolService {

    School save(School school);

    void delete(Long id);

    void delete(School school);

    School getSchoolById(Long id);

    List<School> findAll();

}
