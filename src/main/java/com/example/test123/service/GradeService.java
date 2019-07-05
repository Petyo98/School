package com.example.test123.service;

import com.example.test123.jpa.Grade;

import java.util.List;

public interface GradeService {

    Grade save(Grade grade);

    void delete(Long gradeId);

    void delete(Grade grade);

    Grade getGradeById(Long gradeId);

    List<Grade> findAll();
}
