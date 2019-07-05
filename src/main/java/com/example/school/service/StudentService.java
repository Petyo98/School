package com.example.school.service;

import com.example.school.jpa.Student;

import java.util.List;

public interface StudentService {

    Student save(Student student);

    void delete(Long studentId);

    void delete(Student student);

    Student getStudentById(Long studentId);

    List<Student> findAll();
}
