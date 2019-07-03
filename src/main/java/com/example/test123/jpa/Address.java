package com.example.test123.jpa;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Address extends BaseEntity{
    private String address;
    private Boolean mainaddress;
    @Id
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
