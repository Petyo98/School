package com.example.test123.jpa;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Students123 {
    @Id
    @GeneratedValue(generator = "student123_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "student123_id_seq",
            name = "student123_id_seq", schema = "public", allocationSize = 1, initialValue = 1)
    @Column(name = "id")
    private long id;
    private String name;

    public Students123() {
    }


    public Students123(String name) {
        this.name = name;
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

    @ManyToOne
    @JoinColumn(name="id", insertable = false,updatable = false,nullable = false)
    private Grades123 grades;

    public Grades123 getGrades() {
        return grades;
    }

    public void setGrades(Grades123 grades) {
        this.grades = grades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students123 that = (Students123) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
