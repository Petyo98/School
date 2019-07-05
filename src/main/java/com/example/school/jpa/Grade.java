package com.example.school.jpa;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Grade {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "grades123_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "grades123_id_seq",
            name = "grades123_id_seq", schema = "public", allocationSize = 1, initialValue = 1)
    private Long id;

    @Column(name = "value")
    private Integer value;

    @OneToMany(targetEntity = Student.class, mappedBy = "grade")
    private List<Student> students;

    public Grade() {
    }

    public Grade(Integer value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grade grade = (Grade) o;
        if (students.containsAll(((Grade) o).getStudents()) || ((Grade) o).getStudents().containsAll(students)) {
            return false;
        }

        return id == grade.id &&
                Objects.equals(value, grade.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }
}
