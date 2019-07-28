package com.example.school.jpa;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Class123")
public class StudentClass {

    @Id
    @Column
    @GeneratedValue(generator = "student123_class_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "student123_class_id_seq",
            name = "student123_class_id_seq", schema = "public", allocationSize = 1, initialValue = 1)
    private Long id;

    @Basic
    @Column(name = "name")
    private String name;

    public StudentClass() {
    }

    public StudentClass(String name) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentClass studentClass = (StudentClass) o;
        return id == studentClass.id &&
                Objects.equals(name, studentClass.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
