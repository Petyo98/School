package com.example.test123.repository;

import com.example.test123.jpa.Class123;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends CrudRepository<Class123,Long> {
}
