package com.example.school.service;

import com.example.school.jpa.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher save(Teacher teacher);

    void delete(Long teacherId);

    void delete(Teacher teacher);

    Teacher getTeacherById(Long id);

    List<Teacher> findAll();

}
