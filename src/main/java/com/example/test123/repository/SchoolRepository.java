package com.example.test123.repository;


import com.example.test123.jpa.School112;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends CrudRepository<School112, Long> {
    School112 getSchoolById(long id);
}
