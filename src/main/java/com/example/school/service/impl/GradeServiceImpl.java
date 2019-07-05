package com.example.school.service.impl;

import com.example.school.jpa.Grade;
import com.example.school.repository.GradeRepository;
import com.example.school.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public List<Grade> findAll() {
        return (List<Grade>) gradeRepository.findAll();
    }

    @Override
    public Grade save(Grade grades) {
        return gradeRepository.save(grades);
    }

    @Override
    public void delete(Long gradeId) {
        gradeRepository.deleteById(gradeId);
    }

    @Override
    public void delete(Grade grade) {
        gradeRepository.delete(grade);
    }

    @Override
    public Grade getGradeById(Long gradeId) {
        return gradeRepository.findById(gradeId).orElse(null);
    }

}
