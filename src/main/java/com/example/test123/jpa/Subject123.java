package com.example.test123.jpa;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Subject123 {
    @Id
    @GeneratedValue(generator = "subject123_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "subject123_id_seq",
            name = "subject123_id_seq", schema = "public", allocationSize = 1, initialValue = 1)
    private long id;
    private String name;

    public Subject123() {
    }

    public Subject123(String name) {
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

    @OneToMany(targetEntity=Teachers123.class,mappedBy="subject123", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Teachers123> teachers1s;

    public List<Teachers123> getTeachers1s() {
        return teachers1s;
    }

    public void setTeachers1s(List<Teachers123> teachers1s) {
        this.teachers1s = teachers1s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject123 that = (Subject123) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
