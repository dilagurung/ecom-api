package com.ecommerce.service;

import com.ecommerce.model.Product;

import java.util.List;

/**
 * Created by oa on 6/14/2019.
 */
public interface ProductService
{
    public Product save(Product product);
    public boolean delete(Long id);
    public List<Product> findAll();
    public Product findById(Long id);
    public Product findByName(String name);


}
