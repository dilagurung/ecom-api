package com.ecommerce.service.impl;

import com.ecommerce.model.Customer;
import com.ecommerce.repo.CustomerRepo;
import com.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by oa on 6/28/2019.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
   CustomerRepo customerRepo;

    @Override
    public Customer save(Customer customer) {

        customerRepo.save(customer);
        return customer;
    }

    @Override
    public boolean delete(Long id) {
       customerRepo.deleteById(id);
        return true;
    }

    @Override
    public Customer findById(Long id) {
        return customerRepo.findById(id).get();
    }

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }
}
