package com.example.test123.jpa;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(generator = "teacher_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "teacher_id_seq",
            name = "teacher_id_seq", schema = "public", allocationSize = 1, initialValue = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(targetEntity = Subject.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id", insertable = false, updatable = false, nullable = false)
    private Subject subject;

    @ManyToOne(targetEntity = School.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id", insertable = false, updatable = false, nullable = false)
    private School school;

    public Teacher() {
    }

    public Teacher(String name, School school, Subject subject) {
        this.name = name;
        this.school = school;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id &&
                Objects.equals(name, teacher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
