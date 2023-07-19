package com.brandonn.springboottemplate2.orders.integration.database;

import com.brandonn.springboottemplate2.orders.integration.database.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
}
