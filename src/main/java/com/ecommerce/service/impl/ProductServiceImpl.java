package com.ecommerce.service.impl;

import com.ecommerce.model.Product;
import com.ecommerce.repo.ProductRepo;
import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by oa on 6/14/2019.
 */

@Service
public class ProductServiceImpl implements ProductService
{

    @Autowired
    ProductRepo productRepo;

    @Override
    public Product save(Product product)
    {

        productRepo.save(product);
        return product;
    }

    @Override
    public boolean delete(Long id) {
         productRepo.deleteById(id);
        return true;
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepo.findById(id).get();
    }

    @Override
    public Product findByName(String name) {
        return productRepo.findByName(name);
    }
}
