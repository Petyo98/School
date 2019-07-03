package com.example.test123.jpa;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Address extends BaseEntity{
    @Size(max = 255)
    @NotNull
    private String address;
    private Boolean mainaddress;
    @Id
    @GeneratedValue(generator = "person_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "person_id_sq",name = "person_id_seq",
            schema = "public",allocationSize = 1,initialValue = 1)
    private Long id;

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "mainaddress")
    public Boolean getMainaddress() {
        return mainaddress;
    }

    public void setMainaddress(Boolean mainaddress) {
        this.mainaddress = mainaddress;
    }


    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
