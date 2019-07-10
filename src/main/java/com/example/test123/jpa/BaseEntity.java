package com.example.test123.jpa;

import javax.persistence.*;
import java.util.Date;


@MappedSuperclass
public class BaseEntity {

    private Date createDate;

    private Date updateDate;


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }



    @PrePersist
    public void prePresist(){
        this.createDate = new Date();
    }

    @PreUpdate
    public void preUpdate(){
        this.updateDate  = new Date();
    }
}
