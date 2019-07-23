package com.ecommerce.service.impl;

import com.ecommerce.model.Order;
import com.ecommerce.repo.OrderRepo;
import com.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by oa on 6/28/2019.
 */

@Service
public class OrderServiceImpl implements OrderService
{

    @Autowired
    OrderRepo orderRepo;

    @Override
    public Order save(Order order)
    {
        orderRepo.save(order);
        return order;
    }

    @Override
    public boolean delete(Long id) {
       orderRepo.deleteById(id);
        return true;
    }

    @Override
    public Order findById(Long id) {
        return orderRepo.findById(id).get();
    }

    @Override
    public List<Order> findAll() {
        return orderRepo.findAll();
    }
}
