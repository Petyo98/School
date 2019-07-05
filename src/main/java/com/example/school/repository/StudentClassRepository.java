package com.example.school.repository;

import com.example.school.jpa.StudentClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentClassRepository extends CrudRepository<StudentClass, Long> {
}
