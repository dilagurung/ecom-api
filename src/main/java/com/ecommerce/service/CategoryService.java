package com.ecommerce.service;

import com.ecommerce.model.Category;

import java.util.List;

/**
 * Created by oa on 6/14/2019.
 */
public interface CategoryService
{

    public Category save(Category category);
    public boolean delete(Long id);
    public List<Category> findAll();
    public Category findById(Long id);
    public Category findByName(String name);




}
