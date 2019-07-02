package com.example.test123.service.ServiseInterfaces;

import com.example.test123.jpa.Teachers123;

import java.util.List;

public interface TeachersService {

    List<Teachers123> findAll();
    void addTeacher(Teachers123 teachers123);
    void deleteTeacher(long teacher123Id);
    void getSchoolInfo(long id);

}
