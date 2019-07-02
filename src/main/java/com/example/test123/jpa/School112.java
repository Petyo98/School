package com.example.test123.jpa;

import javax.persistence.*;


import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class School112 {
    @Id
    @GeneratedValue(generator = "school112_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "school112_id_seq",
            name = "school112_id_seq", schema = "public", allocationSize = 1, initialValue = 1)
    @Column(name = "id")
    private long id;
    private String name;
    private Date createdyear;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public School112() {
        }

    public School112(String name, Date createdyear) {

        this.name = name;
        this.createdyear = createdyear;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "createdyear")
    public Date getCreatedyear() {
        return createdyear;
    }

    public void setCreatedyear(Date createdyear) {
        this.createdyear = createdyear;
    }

    @OneToMany(targetEntity=Teachers123.class,mappedBy="school112", cascade = CascadeType.PERSIST,orphanRemoval = true )
    private List<Teachers123> teachers;

    public List<Teachers123> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teachers123> teachers) {
        this.teachers = teachers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School112 school112 = (School112) o;
        return id == school112.id &&
                Objects.equals(name, school112.name) &&
                Objects.equals(createdyear, school112.createdyear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdyear);
    }
}
