package com.example.school.jpa;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class School {

    @Id
    @GeneratedValue(generator = "school_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "school_id_seq",
            name = "school_id_seq", schema = "public", allocationSize = 1, initialValue = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "createdYear")
    private Date createdYear;

    @OneToMany(targetEntity = Teacher.class, mappedBy = "school", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Teacher> teachers;

    public School() {
    }

    public School(String name, Date createdYear) {
        this.name = name;
        this.createdYear = createdYear;
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

    public Date getCreatedYear() {
        return createdYear;
    }

    public void setCreatedYear(Date createdYear) {
        this.createdYear = createdYear;
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
        School school = (School) o;
        return id == school.id &&
                Objects.equals(name, school.name) &&
                Objects.equals(createdYear, school.createdYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdYear);
    }
}
