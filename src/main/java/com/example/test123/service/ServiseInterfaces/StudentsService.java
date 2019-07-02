package com.example.test123.service.ServiseInterfaces;

import com.example.test123.jpa.Students123;

import java.util.List;

public interface StudentsService {
    List<Students123> findAll();
    void addStudent(Students123 students123);
    void editStudent(Students123 students123);
    void deleteStudent(long student123Id);
    Students123 getStudent(long student123Id);
}
