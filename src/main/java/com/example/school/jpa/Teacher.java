package com.example.test123.jpa;

import com.fasterxml.jackson.databind.JsonSerializable;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "teacher123")
public class Teacher  {
    @Id
    @GeneratedValue(generator = "teacher_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "teacher_id_seq",
            name = "teacher_id_seq", schema = "public", allocationSize = 1, initialValue = 1)
    @Column(name = "id")
    private long id;
    private String name;

    public Teacher() {
    }

    public Teacher(String name, School112 school112, Subject123 subject123) {
        this.name = name;
        this.school112 = school112;
        this.subject123 = subject123;

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

    @ManyToOne(targetEntity=Subject123.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name="id", insertable = false,updatable = false,nullable = false)
    private Subject123 subject123;

    @ManyToOne(targetEntity=School112.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name="id", insertable = false,updatable = false,nullable = false)
    private School112 school112;


    public Subject123 getSubject123() {
        return subject123;
    }

    public void setSubject123(Subject123 subject123) {
        this.subject123 = subject123;
    }

    public School112 getSchool112() {
        return school112;
    }

    public void setSchool112(School112 school112) {
        this.school112 = school112;
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
