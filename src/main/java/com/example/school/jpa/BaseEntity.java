package com.example.school.jpa;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;


@MappedSuperclass
public class BaseEntity {

    private Date createdDate;

    private Date updatedDate;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updateDate) {
        this.updatedDate = updateDate;
    }

    @PrePersist
    public void prePresist(){
        this.createdDate = Calendar.getInstance().getTime();
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedDate  = Calendar.getInstance().getTime();
    }
}
