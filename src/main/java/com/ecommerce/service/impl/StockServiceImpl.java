package com.ecommerce.service.impl;

import com.ecommerce.model.Product;
import com.ecommerce.model.Stock;
import com.ecommerce.repo.StockRepo;
import com.ecommerce.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by oa on 6/14/2019.
 */
@Service
public class StockServiceImpl implements StockService {

 @Autowired
    StockRepo stockRepo;

    @Override
    public Stock save(Stock stock) {
        stockRepo.save(stock);
        return stock;
    }

    @Override
    public boolean delete(Long id) {

        stockRepo.deleteById(id);
        return true;
    }

    @Override
    public List<Stock> findAll() {
        return stockRepo.findAll();
    }

    @Override
    public Stock findById(Long id) {
        return stockRepo.findById(id).get();
    }


    @Override
    public Stock findByproduct(Product product) {
        return stockRepo.findByproduct(product);
    }

    @Override
    public Stock findTopByOrderByIdDesc() {
        return findTopByOrderByIdDesc();
    }
}
