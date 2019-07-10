package com.example.test123.service;

import com.example.test123.jpa.Teacher;
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
    public List<Teacher> findAll() {
        return (List<Teacher>) teachersRepository.findAll();
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teachersRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(long teacher123Id) {
        teachersRepository.deleteById(teacher123Id);
    }

    @Override
    public void getSchoolInfo(long id) { teachersRepository.findAll();
    }


}
