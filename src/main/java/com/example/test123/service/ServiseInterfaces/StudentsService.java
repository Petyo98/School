package com.example.test123.service.ServiseInterfaces;

import com.example.test123.jpa.Student;

import java.util.List;

public interface StudentsService {
    List<Student> findAll();
    void addStudent(Student student);
    void editStudent(Student student);
    void deleteStudent(long student123Id);
    Student getStudent(long student123Id);
}
