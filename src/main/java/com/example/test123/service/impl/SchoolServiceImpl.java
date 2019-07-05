package com.example.test123.service.impl;

import com.example.test123.jpa.School;
import com.example.test123.repository.SchoolRepository;
import com.example.test123.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public School save(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public void delete(Long id) {
        schoolRepository.getSchoolById(id);
    }

    @Override
    public void delete(School school) {
        schoolRepository.delete(school);
    }

    @Override
    public School getSchoolById(Long id) {
        return schoolRepository.getSchoolById(id);
    }

    @Override
    public List<School> findAll() {
        return (List<School>) schoolRepository.findAll();
    }
}
