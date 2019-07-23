package com.ecommerce.repo;

import com.ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by oa on 6/14/2019.
 */
public interface CategoryRepo extends JpaRepository<Category,Long>
{
    public Category findByName(String name);
}
