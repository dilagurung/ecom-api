package com.ecommerce.service.impl;

import com.ecommerce.model.Product;
import com.ecommerce.model.ProductCopy;
import com.ecommerce.repo.ProductRepo;
import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by oa on 6/26/2019.
 */
public class ProductCopyServiceImpl implements ProductService
{


    @Autowired
    ProductRepo productRepo;

    @Override
    public Product save(Product product) {

        productRepo.save(product);
        return null;
    }

    @Override
    public boolean delete(Long id)
    {

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
        return null;
    }
}
