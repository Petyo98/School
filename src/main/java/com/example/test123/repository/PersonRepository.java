package com.example.test123.repository;

import com.example.test123.jpa.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    Person getPersonById(Long id);
    List<Person> findByFisrtName(String firstName);
}
