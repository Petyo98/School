package com.example.test123.service;

import com.example.test123.jpa.Grades123;
import com.example.test123.repository.GradesRepository;
import com.example.test123.service.ServiseInterfaces.GradesService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GradesServiceImpl implements GradesService {
    @Autowired
    private GradesRepository gradesRepository;
    private SessionFactory sessionFactory;

    @Override
    public List<Grades123> findAll() {
        return (List<Grades123>) gradesRepository.findAll();
    }

    @Override
    public void addGrades(Grades123 grades123) {
        gradesRepository.save(grades123);
    }

    @Override
    public void editGrades(Grades123 grades123) {
        gradesRepository.save(grades123);
    }

    @Override
    public void deleteGrades(long grades123Id) {
        gradesRepository.deleteById( grades123Id);

    }

    @Override
    public Grades123 getGrades123(int grades123Id) {
      return sessionFactory.getCurrentSession().get(Grades123.class,grades123Id);
    }

}
