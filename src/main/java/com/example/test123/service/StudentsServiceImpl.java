package com.example.test123.service;

import com.example.test123.jpa.Student;
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
    public List<Student> findAll() {
        return (List<Student>) studentsRepository.findAll();
    }

    @Override
    public void addStudent(Student student) {
        studentsRepository.save(student);
    }

    @Override
    public void editStudent(Student student) {

    }

    @Override
    public void deleteStudent(long student123Id) {
        studentsRepository.deleteById(student123Id);
    }

    @Override
    public Student getStudent(long student123Id) {
        return null;
    }
}
