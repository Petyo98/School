package com.example.test123.service.ServiseInterfaces;

import com.example.test123.jpa.Subject123;

import java.util.List;

public interface SubjectService {
    List<Subject123> findAll();
    void addSubject(Subject123 students123);
    void editSubject(Subject123 students123);
    void deleteSubject(long subject123Id);
    Subject123 getSubject(long subject123Id);
}
