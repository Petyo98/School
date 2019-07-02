package com.example.test123.service.ServiseInterfaces;

import com.example.test123.jpa.Class123;

import java.util.List;

public interface ClassService {

    List<Class123> findAll();
    void addClass(Class123 grades123);
    void editClass(Class123 grades123);
    void deleteClass(long class123Id);

}
