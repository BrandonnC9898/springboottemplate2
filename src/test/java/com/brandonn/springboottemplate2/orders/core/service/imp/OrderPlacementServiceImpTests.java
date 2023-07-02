package com.brandonn.springboottemplate2.orders.core.service.imp;

import com.brandonn.springboottemplate2.orders.core.dto.CreateOrderPlacementRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class OrderPlacementServiceImpTests {

    private OrderPlacementServiceImp service;

    @BeforeEach
    public void init() {
        service = new OrderPlacementServiceImp();
    }

    @Test
    public void whenCreateShouldNotReturnNull() {
        CreateOrderPlacementRequestDto request = new CreateOrderPlacementRequestDto();
        request.setCustomerId(1L);
        request.setSalesmanId(1L);
        request.setOrderDate(LocalDate.now());
        request.setItems(new ArrayList<>());
        assertNotNull(service.create(request));
    }
}
