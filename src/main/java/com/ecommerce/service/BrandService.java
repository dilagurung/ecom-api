package com.ecommerce.service;

import com.ecommerce.model.Brand;

import java.util.List;

/**
 * Created by oa on 6/18/2019.
 */
public interface BrandService
{
   public  Brand save(Brand brand);
   public void deleteById(Long id);
   public void update(Brand brand);
   public Brand findById(Long id);
   public List<Brand> findAll();


}
