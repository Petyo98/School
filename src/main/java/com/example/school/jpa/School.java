package com.example.school.jpa;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import com.example.school.jpa.Teacher;
@Entity
@Table(name = "School112")
public class School {

    @Id
    @GeneratedValue(generator = "school112_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "school112_id_seq",
            name = "school112_id_seq", schema = "public", allocationSize = 1, initialValue = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "createdyear")
    private Date createdyear;

    @OneToMany(targetEntity = Teacher.class, mappedBy = "school", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Teacher> teachers;

    public School() {
    }

    public School(String name, Date createdYear) {
        this.name = name;
        this.createdyear = createdYear;
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
        return createdyear;
    }

    public void setCreatedYear(Date createdYear) {
        this.createdyear = createdYear;
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
                Objects.equals(createdyear, school.createdyear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdyear);
    }
}
