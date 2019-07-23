package com.ecommerce.repo;

import com.ecommerce.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by oa on 6/18/2019.
 */
public interface BrandRepo extends JpaRepository<Brand,Long> {
}
