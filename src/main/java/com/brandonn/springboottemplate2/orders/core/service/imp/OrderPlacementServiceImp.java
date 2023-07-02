package com.brandonn.springboottemplate2.orders.core.service.imp;

import com.brandonn.springboottemplate2.orders.core.bo.OrderBo;
import com.brandonn.springboottemplate2.orders.core.dto.CreateOrderPlacementRequestDto;
import com.brandonn.springboottemplate2.orders.core.service.OrderPlacementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderPlacementServiceImp implements OrderPlacementService {

    @Override
    public OrderBo create(CreateOrderPlacementRequestDto request) {
        /* TO-DO
        * calculate the total amount
        * remove the money from the customer
        * subtract the quantity of products from inventory
        * create the order and order items registries
        * */
        log.info("create request: {}", request);
        return null;
    }
}
