package com.example.school.service;

import com.example.school.jpa.StudentClass;

import java.util.List;

public interface StudentClassService {

    StudentClass save(StudentClass studentClass);

    void delete(Long studentClassId);

    void delete(StudentClass studentClass);

    List<StudentClass> findAll();

}
