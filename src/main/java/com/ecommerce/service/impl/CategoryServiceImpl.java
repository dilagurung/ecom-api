package com.ecommerce.service.impl;

import com.ecommerce.model.Category;
import com.ecommerce.repo.CategoryRepo;
import com.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by oa on 6/14/2019.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepo categoryRepo;
    @Override
    public Category save(Category category) {
        categoryRepo.save(category);
        return category;
    }

    @Override
    public boolean delete(Long id) {
        categoryRepo.deleteById(id);
        return true;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepo.findById(id).get();
    }

    @Override
    public Category findByName(String name) {
        return categoryRepo.findByName(name);
    }
}
