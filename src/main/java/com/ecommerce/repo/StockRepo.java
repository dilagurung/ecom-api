package com.ecommerce.repo;

import com.ecommerce.model.Category;
import com.ecommerce.model.Product;
import com.ecommerce.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by oa on 6/14/2019.
 */
public interface StockRepo extends JpaRepository<Stock,Long>
{
    Stock findByproduct(Product product);
    Stock findTopByOrderByIdDesc();

}
