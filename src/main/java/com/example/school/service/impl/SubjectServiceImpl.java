package com.example.school.service.impl;

import com.example.school.jpa.Subject;
import com.example.school.repository.SubjectRepository;
import com.example.school.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void delete(Long subjectId) {
        subjectRepository.deleteById(subjectId);
    }

    @Override
    public void delete(Subject subject) {
        subjectRepository.delete(subject);
    }

    @Override
    public Subject getSubjectById(Long subjectId) {
        return subjectRepository.findById(subjectId).orElse(null);
    }

    @Override
    public List<Subject> findAll() {
        return (List<Subject>) subjectRepository.findAll();
    }
}
