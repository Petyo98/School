package com.example.test123.service;

import com.example.test123.jpa.Subject123;
import com.example.test123.repository.SubjectRepository;
import com.example.test123.service.ServiseInterfaces.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository ;

    @Override
    public List<Subject123> findAll() {
        return (List<Subject123>) subjectRepository.findAll();
    }

    @Override
    public void addSubject(Subject123 subject123) {
        subjectRepository.save(subject123);
    }

    @Override
    public void editSubject(Subject123 subject123) {

    }

    @Override
    public void deleteSubject(long subject123Id) {
        subjectRepository.deleteById(subject123Id);
    }

    @Override
    public Subject123 getSubject(long subject123Id) {
        return null;
    }
}
