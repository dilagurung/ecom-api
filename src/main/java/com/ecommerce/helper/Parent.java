package com.ecommerce.helper;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@MappedSuperclass
@Data
    public abstract class Parent {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on", updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    protected Date createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_modified", insertable = false)
    @org.hibernate.annotations.UpdateTimestamp
    protected Date lastModified;

    //    @Lob          you need byte code instrumentation
    @Column(name = "description")
    @org.hibernate.annotations.ColumnDefault("'No Description'")
    protected String description;



}
