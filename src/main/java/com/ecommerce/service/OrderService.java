package com.ecommerce.service;

import com.ecommerce.model.Order;

import java.util.List;

/**
 * Created by oa on 6/28/2019.
 */
public interface OrderService
{

    public Order save(Order order);
    public boolean delete(Long id);
    public Order findById(Long id);
    public List<Order> findAll();

}
