package com.example.test123.service;

import com.example.test123.jpa.StudentClass;

import java.util.List;

public interface StudentClassService {

    StudentClass save(StudentClass studentClass);

    void delete(Long studentClassId);

    void delete(StudentClass studentClass);

    List<StudentClass> findAll();

}
