package com.brandonn.springboottemplate2.products.core.service.imp;

import com.brandonn.springboottemplate2.products.integration.database.ProductRepository;
import com.brandonn.springboottemplate2.products.integration.database.entity.ProductEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class ProductServiceImpTests {

    private final ProductRepository repository = Mockito.mock(ProductRepository.class);

    private ProductServiceImp service;

    private final List<ProductEntity> productEntities;

    public ProductServiceImpTests() {
        productEntities = new ArrayList<>();
        ProductEntity product1 = new ProductEntity();
        product1.setProductId(1L);
        product1.setListPrice(BigDecimal.valueOf(1500L));

        ProductEntity product2 = new ProductEntity();
        product2.setProductId(10L);
        product2.setListPrice(BigDecimal.valueOf(2000L));

        productEntities.add(product1);
        productEntities.add(product2);
    }

    @BeforeEach
    public void init() {
        service = new ProductServiceImp(repository);
    }

    @Test
    public void whenCalculatePriceShouldReturnPrice() {
        // Mock
        List<ProductEntity> repoRes = new ArrayList<>();
        repoRes.add(productEntities.get(0));
        when(repository.findAllById(new HashSet<>(Arrays.asList(1L)))).thenReturn(repoRes);
        // Request
        Map<Long, Integer> request = new HashMap<>();
        request.put(1L, 2);
        // Test
        assertEquals(BigDecimal.valueOf(3000L), service.calculateTotalPrice(request));
    }

    @Test
    public void whenCalculatePriceForTwoShouldReturnPrice() {
        // Mock
        List<ProductEntity> repoRes = new ArrayList<>();
        repoRes.add(productEntities.get(0));
        repoRes.add(productEntities.get(1));
        when(repository.findAllById(new HashSet<>(Arrays.asList(1L, 10L)))).thenReturn(repoRes);
        // Request
        Map<Long, Integer> request = new HashMap<>();
        request.put(1L, 2);
        request.put(10L, 3);
        // Test
        assertEquals(BigDecimal.valueOf(9000L), service.calculateTotalPrice(request));
    }

    @Test
    public void whenCalculatePriceCantFindProductShouldReturnNull() {
        // Mock
        List<ProductEntity> repoRes = new ArrayList<>();
        repoRes.add(productEntities.get(0));
        when(repository.findAllById(new HashSet<>(Arrays.asList(1L, 10L)))).thenReturn(repoRes);
        // Request
        Map<Long, Integer> request = new HashMap<>();
        request.put(1L, 2);
        request.put(10L, 3);
        // Test
        assertNull(service.calculateTotalPrice(request));
    }
}
