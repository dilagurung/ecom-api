package com.ecommerce.service;

import com.ecommerce.model.Product;
import com.ecommerce.model.Stock;

import java.util.List;

/**
 * Created by oa on 6/14/2019.
 */
public interface StockService {

    public Stock save(Stock stock);
    public boolean delete(Long id);
    public List<Stock> findAll();
    public Stock findById(Long id);
    public Stock findByproduct(Product product);
    public Stock findTopByOrderByIdDesc();



}
