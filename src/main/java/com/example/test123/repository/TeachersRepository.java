package com.example.test123.repository;

import com.example.test123.jpa.Teachers123;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachersRepository extends CrudRepository<Teachers123,Long> {
}
