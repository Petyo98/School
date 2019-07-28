package com.example.school.jpa;

import com.example.school.jpa.School;
import com.example.school.jpa.Subject;
import com.fasterxml.jackson.databind.JsonSerializable;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "teachers123")
public class Teacher  {
    @Id
    @GeneratedValue(generator = "teachers123_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "teachers123_id_seq",
            name = "teachers123_id_seq", schema = "public", allocationSize = 1, initialValue = 1)
    @Column(name = "id")
    private long id;
    private String name;

    public Teacher() {
    }

    public Teacher(String name, School school, Subject subject) {
        this.name = name;
        this.school = school;
        this.subject = subject;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @ManyToOne(targetEntity=Subject.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name="id", insertable = false,updatable = false,nullable = false)
    private Subject subject;

    @ManyToOne(targetEntity=School.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name="id", insertable = false,updatable = false,nullable = false)
    private School school;


    public Subject getSubject123() {
        return subject;
    }

    public void setSubject123(Subject subject) {
        this.subject = subject;
    }

    public School getSchool112() {
        return school;
    }

    public void setSchool112(School school) {
        this.school = school;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher that = (Teacher) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
