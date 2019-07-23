package com.ecommerce.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by oa on 6/28/2019.
 */

@Entity
@Table(name="customer_order")
public class Order
{
    @Id
    @GeneratedValue
    private Long id;
    private Date orderDate;
    private Date deliveryDate;
    @ManyToOne
    @JoinColumn(name="customer")
    private Customer customer;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
