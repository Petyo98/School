package com.example.school.jpa;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "students123")
public class Student {
    @Id
    @GeneratedValue(generator = "student123_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "student123_id_seq",
            name = "student123_id_seq", schema = "public", allocationSize = 1, initialValue = 1)
    @Column(name = "id")
    private Long id;
    private String name;
//    @ManyToOne
//    @JoinColumn(name = "id", insertable = false,updatable = false,nullable = false)
//    private Person person;

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
    @JoinColumn(name="id", insertable = false, updatable = false, nullable = false)
    private Grade grade;

    public Grade getGrades() {
        return grade;
    }

    public void setGrades(Grade grades) {
        this.grade = grades;
    }

//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }



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
