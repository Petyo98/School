package com.example.test123.repository;

import com.example.test123.jpa.Subject123;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SubjectRepository extends CrudRepository<Subject123,Long> {
}
