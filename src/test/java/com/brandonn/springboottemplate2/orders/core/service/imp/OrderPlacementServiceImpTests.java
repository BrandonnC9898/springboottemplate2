package com.brandonn.springboottemplate2.orders.core.service.imp;

import com.brandonn.springboottemplate2.orders.core.dto.CreateOrderPlacementRequestDto;
import com.brandonn.springboottemplate2.orders.integration.database.OrderRepository;
import com.brandonn.springboottemplate2.products.core.service.InventoryService;
import com.brandonn.springboottemplate2.products.core.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderPlacementServiceImpTests {

    private final ProductService productService = Mockito.mock(ProductService.class);

    private final InventoryService inventoryService = Mockito.mock(InventoryService.class);

    private final OrderRepository orderRepository = Mockito.mock(OrderRepository.class);

    private OrderPlacementServiceImp service;

    @BeforeEach
    public void init() {
        service = new OrderPlacementServiceImp(productService, inventoryService, orderRepository);
    }

    //@Test
    public void whenCreateShouldNotReturnNull() {
        CreateOrderPlacementRequestDto request = new CreateOrderPlacementRequestDto();
        request.setCustomerId(1L);
        request.setSalesmanId(1L);
        request.setOrderDate(new Date().toString());
        request.setItems(new ArrayList<>());
        assertNotNull(service.create(request));
    }
}
