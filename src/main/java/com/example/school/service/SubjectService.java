package com.example.school.service;

import com.example.school.jpa.Subject;

import java.util.List;

public interface SubjectService {

    Subject save(Subject subject);

    void delete(Long subjectId);

    void delete(Subject subject);

    Subject getSubjectById(Long subjectId);

    List<Subject> findAll();
}
