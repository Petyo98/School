package com.example.test123.jpa;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Class123 {
    @Id
    @Column
    @GeneratedValue(generator = "class123_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "class123_id_seq",
            name = "class123_id_seq", schema = "public", allocationSize = 1, initialValue = 1)
    private long id;
    private String name;

    public Class123() {
    }

    public Class123(String name) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Class123 class123 = (Class123) o;
        return id == class123.id &&
                Objects.equals(name, class123.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
