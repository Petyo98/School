package com.example.test123.repository;

import com.example.test123.jpa.Grades123;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradesRepository extends CrudRepository<Grades123,Long> {
}
