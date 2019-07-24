package com.ecommerce.repo;

import com.ecommerce.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by oa on 7/24/2019.
 */
public interface LoginRepo extends JpaRepository<Login,Long> {
}
