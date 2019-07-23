package com.ecommerce.repo;

import com.ecommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by oa on 6/28/2019.
 */
public interface OrderRepo extends JpaRepository<Order,Long> {
}
