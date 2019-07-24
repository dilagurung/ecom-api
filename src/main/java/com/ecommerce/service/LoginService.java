package com.ecommerce.service;

import com.ecommerce.model.Login;

import java.util.List;

/**
 * Created by oa on 7/24/2019.
 */
public interface LoginService
{

    public Login save(Login login);
    public Login findById(Long id);
    public List<Login> findByAll();
    public boolean deleteById(Long id);
    public Login update(Login login);


}
