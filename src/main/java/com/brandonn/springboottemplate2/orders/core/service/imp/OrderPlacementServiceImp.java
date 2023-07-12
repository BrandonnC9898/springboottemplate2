package com.brandonn.springboottemplate2.orders.core.service.imp;

import com.brandonn.springboottemplate2.orders.core.bo.OrderBo;
import com.brandonn.springboottemplate2.orders.core.dto.CreateOrderPlacementRequestDto;
import com.brandonn.springboottemplate2.orders.core.service.OrderPlacementService;
import com.brandonn.springboottemplate2.products.core.service.InventoryService;
import com.brandonn.springboottemplate2.products.core.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class OrderPlacementServiceImp implements OrderPlacementService {

    private final ProductService productService;

    private final InventoryService inventoryService;

    public OrderPlacementServiceImp(ProductService productService, InventoryService inventoryService) {
        this.productService = productService;
        this.inventoryService = inventoryService;
    }

    @Override
    public OrderBo create(CreateOrderPlacementRequestDto request) {
        /* Process:
        * calculate the total amount
        * remove the money from the customer
        * subtract the quantity of products from inventory
        * create the order and order items registries
        * */
        log.info("create request: {}", request);
        Map<Long, Integer> productItems = new HashMap<>();
        request.getItems().forEach(p -> productItems.put(p.getProductId(), p.getQuantity()));
        BigDecimal total = productService.calculateTotalPrice(productItems);
        log.info("Total price: {}", total);
        // TO-DO: remove the money from the customer
        inventoryService.subtract(productItems);
        return null;
    }
}
