package com.example.test123.repository;

import com.example.test123.jpa.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends CrudRepository<Student,Long> {
}
