package com.example.test123.service.ServiseInterfaces;

import com.example.test123.jpa.Grades123;

import java.util.List;

public interface GradesService {

    List<Grades123> findAll();
    void addGrades(Grades123 grades123);
    void editGrades(Grades123 grades123);
    void deleteGrades(long grades123Id);
    Grades123 getGrades123 (int grades123Id);
}
