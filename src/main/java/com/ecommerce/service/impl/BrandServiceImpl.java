package com.ecommerce.service.impl;

import com.ecommerce.model.Brand;
import com.ecommerce.repo.BrandRepo;
import com.ecommerce.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by oa on 6/18/2019.
 */

@Service
public class BrandServiceImpl implements BrandService {



    @Autowired
    BrandRepo brandRepo;

    @Override
    public Brand save(Brand brand) {
    brandRepo.save(brand);
        return brand;
    }

    @Override
    public void deleteById(Long id) {

        brandRepo.deleteById(id);
    }

    @Override
    public void update(Brand brand) {

        brandRepo.saveAndFlush(brand);
    }

    @Override
    public Brand findById(Long id) {
        return brandRepo.findById(id).get();
    }

    @Override
    public List<Brand> findAll() {
        return brandRepo.findAll();
    }
}
