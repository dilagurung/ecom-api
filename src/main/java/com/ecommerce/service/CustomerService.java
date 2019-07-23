package com.ecommerce.service;

import com.ecommerce.model.Customer;

import java.util.List;

/**
 * Created by oa on 6/28/2019.
 */
public interface CustomerService
{
    public Customer save(Customer customer);
    public boolean delete(Long id);
    public Customer findById(Long id);
    public List<Customer> findAll();
}
