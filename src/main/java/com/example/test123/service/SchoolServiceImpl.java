package com.example.test123.service;



import com.example.test123.jpa.School112;
import com.example.test123.repository.SchoolRepository;
import com.example.test123.service.ServiseInterfaces.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private EntityManager entityManager;


    @Override
    public List<School112> findAll() {
        return  (List<School112>) schoolRepository.findAll();
    }

    @Override
    public void addSchool(School112 School) {
        schoolRepository.save(School);
    }


    @Override
    public void deleteSchool(long id) {
        schoolRepository.deleteById(id);
    }

    @Override
    public School112 getSchoo112ById(Long id) {
        return schoolRepository.getSchoolById(id);

    }


}
