package com.brandonn.springboottemplate2.products.core.service;

import java.util.Map;

public interface InventoryService {
    boolean subtract(Map<Long, Integer> products);
}
