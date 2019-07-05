package com.example.test123.service;

import com.example.test123.jpa.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher save(Teacher teacher);

    void delete(Long teacherId);

    void delete(Teacher teacher);

    Teacher getTeacherById(Long id);

    List<Teacher> findAll();

}
