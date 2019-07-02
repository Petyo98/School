package com.example.test123.service;

import com.example.test123.jpa.Students123;
import com.example.test123.repository.StudentsRepository;
import com.example.test123.service.ServiseInterfaces.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsServiceImpl implements StudentsService {

    @Autowired
    private StudentsRepository studentsRepository;

    @Override
    public List<Students123> findAll() {
        return (List<Students123>) studentsRepository.findAll();
    }

    @Override
    public void addStudent(Students123 students123) {
        studentsRepository.save(students123);
    }

    @Override
    public void editStudent(Students123 students123) {

    }

    @Override
    public void deleteStudent(long student123Id) {
        studentsRepository.deleteById(student123Id);
    }

    @Override
    public Students123 getStudent(long student123Id) {
        return null;
    }
}
