package com.example.school.jpa;

import com.example.school.jpa.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
public class Person extends BaseEntity {
    @Id
    @GeneratedValue(generator = "person_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "person_id_sq",name = "person_id_seq",
            schema = "public",allocationSize = 1,initialValue = 1)
    private Long id;
    private String fisrtName;
    private String secondName;
    private String lastName;


    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fisrt_name", length = 50)
    public String getFisrtName() {
        return fisrtName;
    }

    public void setFisrtName(String fisrtName) {
        this.fisrtName = fisrtName;
    }

    @Basic
    @Column(name = "second_name", length = 50)
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "last_name", length = 50)
    public String getLastName() {
        return lastName;
    }


//    @OneToMany(targetEntity= Student.class,mappedBy="Person", cascade = CascadeType.PERSIST, orphanRemoval = true)
//    private List<Student> students;
//
//    public List<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(List<Student> students) {
//        this.students = students;
//    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(fisrtName, person.fisrtName) &&
                Objects.equals(secondName, person.secondName) &&
                Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fisrtName, secondName, lastName);
    }
}
