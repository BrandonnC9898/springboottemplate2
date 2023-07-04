package com.brandonn.springboottemplate2.orders.core.service.imp;

import com.brandonn.springboottemplate2.orders.core.dto.CreateOrderPlacementRequestDto;
import com.brandonn.springboottemplate2.products.core.service.InventoryService;
import com.brandonn.springboottemplate2.products.core.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class OrderPlacementServiceImpTests {

    private final ProductService productService = Mockito.mock(ProductService.class);

    private final InventoryService inventoryService = Mockito.mock(InventoryService.class);

    private OrderPlacementServiceImp service;

    @BeforeEach
    public void init() {
        service = new OrderPlacementServiceImp(productService, inventoryService);
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
