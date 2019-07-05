package com.example.test123.repository;

import com.example.test123.jpa.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonSpec {

    private final static String FIRST_NAME = "first name";

    private final static String SECOND_NAME = "second name";

    private final static String LAST_NAME = "last name";

    private final static String TEST_NAME = "test";

    @Autowired
    private PersonRepository repository;

    @Test
    public void testAddPerson() {
        Person person = new Person();
        person.setFisrtName(FIRST_NAME);
        person.setSecondName(SECOND_NAME);
        person.setLastName(LAST_NAME);

        Person savedPerson = repository.save(person);

        assertEquals(1, repository.count());
    }


    @Test
    public void testEditPerson() {
        Person person = new Person();
        person.setFisrtName(FIRST_NAME);
        person.setSecondName(SECOND_NAME);
        person.setLastName(LAST_NAME);

        person = repository.save(person);

        assertNotNull(person);
        String oldFirstName = person.getFisrtName();

        Person newPerson = repository.findById(person.getId()).get();
        newPerson.setFisrtName(TEST_NAME);

        newPerson = repository.save(newPerson);

        assertEquals(person.getId(), newPerson.getId());
        assertNotEquals(oldFirstName, newPerson.getFisrtName());
    }

    @Test
    public void testSearchPerson() {
        Person person = new Person();
        person.setFisrtName(FIRST_NAME);
        person.setSecondName(SECOND_NAME);
        person.setLastName(LAST_NAME);

        person = repository.save(person);

        List<Person> foundPersons = repository.findByFisrtName(FIRST_NAME);
        assertEquals(1, foundPersons.size());
    }

    @Test
    public void testDeletePerson() {

        Person person = new Person();
        person.setFisrtName(FIRST_NAME);
        person.setSecondName(SECOND_NAME);
        person.setLastName(LAST_NAME);

        person = repository.save(person);
        assertEquals(1, repository.count());

        repository.delete(person);

        assertEquals(0, repository.count());
    }
}
