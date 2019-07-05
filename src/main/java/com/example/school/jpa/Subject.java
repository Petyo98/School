package com.example.school.jpa;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Subject {

    @Id
    @GeneratedValue(generator = "subject_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "subject_id_seq",
            name = "subject_id_seq", schema = "public", allocationSize = 1, initialValue = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(targetEntity = Teacher.class, mappedBy = "subject", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Teacher> teachers;

    public Subject() {
    }

    public Subject(String name) {
        this.name = name;
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

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return id == subject.id &&
                Objects.equals(name, subject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
