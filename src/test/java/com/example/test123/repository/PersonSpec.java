package com.example.test123.repository;

import com.example.test123.jpa.Person;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonSpec {

    @Autowired
    private PersonRepository repository;


    @Test
    public void testAddPerson() {
        Person person = new Person();
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date.toString());
        person.setFisrtName("test");
        person.setSecondName("second name");
        person.setLastName("last name");
        person.setCreateDate(date);
        person.setUpdateDate(null);

        Person savedPerson = repository.save(person);

        assertEquals(1, repository.count());
//        assertNotNull(savedPerson.getCreateDate());
//        System.out.println(savedPerson.getCreateDate());

    }


    @Test
    public void testEditPerson(){
        Person person = new Person();
        Date date = new Date(System.currentTimeMillis());

        person.setFisrtName("test");
        person.setSecondName("second name");
        person.setLastName("last name");
        person.setCreateDate(date);
        person.setUpdateDate(null);
        repository.save(person);
        Person newPerson = new Person();
        newPerson.setId(person.getId());
        newPerson.setFisrtName("new test");
        newPerson.setSecondName("new second name");
        newPerson.setLastName("new last name");
        newPerson.setCreateDate(person.getCreateDate());
        newPerson.setUpdateDate(date);
        repository.save(person);
        assertEquals(person.getId(), newPerson.getId());

    }

    @Test
    public void testSearchPerson(){
        Person person = new Person();
        person.setFisrtName("dasdasd");
        repository.save(person);
        assertEquals(person.getFisrtName(), "dasdasd");
    }

    @Test
    public void testDeletePerson(){

        Person person = new Person();
        person.setFisrtName("sdfsdfsdf");
        Person savedPerson = repository.save(person);
        savedPerson.setSecondName("dsfdsf");
        Person updatedPerson = repository.save(savedPerson);

        assertEquals(1,repository.count());
        repository.delete(savedPerson);

        assertEquals(0,repository.count());

    }


    @Test//(expected = NullPointerException.class)
    @Ignore
    public void testLengthFirstName(){
        Person person = new Person();
        person.setFisrtName("gfgdgdgdgdgfdgfdgfdggdd");

        repository.save(person);

    }
}
