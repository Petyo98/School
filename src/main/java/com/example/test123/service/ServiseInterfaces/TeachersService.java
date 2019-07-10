package com.example.test123.service.ServiseInterfaces;

import com.example.test123.jpa.Teacher;

import java.util.List;

public interface TeachersService {

    List<Teacher> findAll();
    void addTeacher(Teacher teacher);
    void deleteTeacher(long teacher123Id);
    void getSchoolInfo(long id);

}
