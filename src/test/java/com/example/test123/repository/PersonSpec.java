package com.example.test123.repository;

import com.example.test123.jpa.Person;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.sql.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonSpec {

    @Autowired
    private PersonRepository repository;


    @Test
    public void testAddPerson() {
        Person person = new Person();
        person.setFisrtName("test");
        person.setSecondName("second name");
        person.setLastName("last name");
        person.setCreateDate(new Date(1998,2,13));
        person.setUpdateDate(null);

        Person savedPerson = repository.save(person);

        assertEquals(1, repository.count());
//        assertNotNull(savedPerson.getCreateDate());
//        System.out.println(savedPerson.getCreateDate());

    }


    @Test
    public void testEditPerson(){
        Person person = new Person();
        person.setFisrtName("test");
        person.setSecondName("second name");
        person.setLastName("last name");
        person.setCreateDate(new Date(1998,2,13));
        person.setUpdateDate(null);

        Person newPerson = new Person();
        newPerson.setId(person.getId());
        newPerson.setFisrtName("new test");
        newPerson.setSecondName("new second name");
        newPerson.setLastName("new last name");
        newPerson.setCreateDate(person.getCreateDate());
        newPerson.setUpdateDate(new Date(2019,7,3));
        assertEquals(person.getId(), newPerson.getId());

    }
  //za relaciq i varchar testove

    @Test
    public void testSearchPerson(){
        Person person = new Person();
        person.setFisrtName("dasdasd");
        assertEquals(person.getFisrtName(), "dasdasd");
    }
//delete methoda ne e gotov
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
        person.setFisrtName("rewrsadasdasdrewrsadasdasdrewrsadasdasdrewrsadasdasdffffrewrsadasdasdrewrsadasdasdrewrsadasdasdrewrsadasdasdffffrewrsadasdasdrewrsadasdasdrewrsadasdasdrewrsadasdasdffffrewrsadasdasdrewrsadasdasdrewrsadasdasdrewrsadasdasdffffrewrsadasdasdrewrsadasdasdrewrsadasdasdrewrsadasdasdffffrewrsadasdasdrewrsadasdasdrewrsadasdasdrewrsadasdasdffffrewrsadasdasdrewrsadasdasdrewrsadasdasdrewrsadasdasdffffrewrsadasdasdrewrsadasdasdrewrsadasdasdrewrsadasdasdffffrewrsadasdasdrewrsadasdasdrewrsadasdasdrewrsadasdasdffff");

        repository.save(person);

    }
}
