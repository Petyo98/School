package com.example.test123.service.ServiseInterfaces;



import com.example.test123.jpa.School112;

import java.sql.Date;
import java.util.List;

public interface SchoolService {

    List<School112> findAll();
    void addSchool(School112 school112);
    void deleteSchool(long id);
    School112 getSchoo112ById (Long id);

}
