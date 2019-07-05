package com.example.school.repository;


import com.example.school.jpa.School;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends CrudRepository<School, Long> {
    School getSchoolById(Long id);
}
