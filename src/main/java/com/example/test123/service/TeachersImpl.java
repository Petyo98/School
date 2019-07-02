package com.example.test123.service;

import com.example.test123.jpa.Teachers123;
import com.example.test123.repository.TeachersRepository;
import com.example.test123.service.ServiseInterfaces.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeachersImpl implements TeachersService {
    @Autowired
    private TeachersRepository teachersRepository;

    @Override
    public List<Teachers123> findAll() {
        return (List<Teachers123>) teachersRepository.findAll();
    }

    @Override
    public void addTeacher(Teachers123 teachers123) {
        teachersRepository.save(teachers123);
    }

    @Override
    public void deleteTeacher(long teacher123Id) {
        teachersRepository.deleteById(teacher123Id);
    }

    @Override
    public void getSchoolInfo(long id) { teachersRepository.findAll();
    }


}
