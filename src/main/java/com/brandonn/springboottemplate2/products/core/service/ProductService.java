package com.brandonn.springboottemplate2.products.core.service;

import java.math.BigDecimal;
import java.util.Map;

public interface ProductService {
    BigDecimal calculateTotalPrice(Map<Long, Integer> products);
}
