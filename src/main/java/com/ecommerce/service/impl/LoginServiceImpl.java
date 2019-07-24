package com.ecommerce.service.impl;

import com.ecommerce.model.Login;
import com.ecommerce.repo.LoginRepo;
import com.ecommerce.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by oa on 7/24/2019.
 */

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepo loginRepo;

    @Override
    public Login save(Login login) {

     loginRepo.save(login);
        return login;
    }

    @Override
    public Login findById(Long id)
    {
       Login login= loginRepo.findById(id).get();
        return login;
    }

    @Override
    public List<Login> findByAll() {
        return loginRepo.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
       loginRepo.deleteById(id);
        return true;
    }

    @Override
    public Login update(Login login) {
        loginRepo.saveAndFlush(login);
        return login;
    }
}
