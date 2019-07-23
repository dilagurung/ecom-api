package com.ecommerce.repo;

import com.ecommerce.model.Category;
import com.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by oa on 6/14/2019.
 */
public interface ProductRepo extends JpaRepository<Product,Long>
{
    public Product findByName(String name);

}
