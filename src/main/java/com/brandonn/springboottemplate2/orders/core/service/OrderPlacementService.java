package com.brandonn.springboottemplate2.orders.core.service;

import com.brandonn.springboottemplate2.orders.core.bo.OrderBo;
import com.brandonn.springboottemplate2.orders.core.dto.CreateOrderPlacementRequestDto;

public interface OrderPlacementService {
    OrderBo create(CreateOrderPlacementRequestDto request);
}
