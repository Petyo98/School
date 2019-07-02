package com.example.test123.jpa;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

@Entity
public class Grades123 {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "grades123_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "grades123_id_seq",
            name = "grades123_id_seq", schema = "public", allocationSize = 1, initialValue = 1)
    private long id;
    private Integer value;

    public Grades123() {
    }

    public Grades123(Integer value) {
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "value")
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @OneToMany(targetEntity=Students123.class,mappedBy="grades")
    private List<Students123> students;

    public List<Students123> getStudents() {
        return students;
    }

    public void setStudents(List<Students123> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grades123 grades123 = (Grades123) o;
        return id == grades123.id &&
                Objects.equals(value, grades123.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }
}
