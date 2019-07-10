package com.example.test123.jpa;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.hibernate.validator.constraints.UniqueElements;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "students123")
public class Student {
    @Id
    @GeneratedValue(generator = "student_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "student_id_seq",
            name = "student_id_seq", schema = "public", allocationSize = 1, initialValue = 1)
    @Column(name = "id")
    private Long id;
    private String name;
//    @ManyToOne
//    @JoinColumn(name = "id")
//    private Person person;

    private Integer identityNumber;

    public Student() {
    }


    public Student(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name="id", insertable = false,updatable = false,nullable = false)
    private Grades123 grades;

    public Grades123 getGrades() {
        return grades;
    }

    public void setGrades(Grades123 grades) {
        this.grades = grades;
    }

//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }

    public Integer getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(Integer identityNumber) {
        this.identityNumber = identityNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student that = (Student) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
