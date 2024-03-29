package com.example.school.jpa;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;
import com.example.school.jpa.Person;

@Entity
public class Address extends BaseEntity{

    @Id
    @GeneratedValue(generator = "person_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "person_id_sq",name = "person_id_seq",
            schema = "public",allocationSize = 1, initialValue = 1)
    @Column(name = "id")
    private Long id;

    @Size(max = 255)
    @NotNull
    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "mainaddress")
    private Boolean mainaddress;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getMainaddress() {
        return mainaddress;
    }

    public void setMainaddress(Boolean mainaddress) {
        this.mainaddress = mainaddress;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return id == address1.id &&
                Objects.equals(address, address1.address) &&
                Objects.equals(mainaddress, address1.mainaddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, mainaddress, id);
    }
}
