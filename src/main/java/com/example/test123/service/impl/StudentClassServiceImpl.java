package com.example.test123.service.impl;

import com.example.test123.jpa.StudentClass;
import com.example.test123.repository.StudentClassRepository;
import com.example.test123.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentClassServiceImpl implements StudentClassService {

    @Autowired
    StudentClassRepository studentClassRepository;

    @Override
    public StudentClass save(StudentClass studentClass) {
        return studentClassRepository.save(studentClass);
    }

    @Override
    public void delete(Long classId) {
        studentClassRepository.deleteById(classId);
    }

    @Override
    public void delete(StudentClass studentClass) {
        studentClassRepository.delete(studentClass);
    }

    @Override
    public List<StudentClass> findAll() {
        return (List<StudentClass>) studentClassRepository.findAll();
    }


}
