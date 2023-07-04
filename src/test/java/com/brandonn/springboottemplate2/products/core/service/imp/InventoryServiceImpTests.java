package com.brandonn.springboottemplate2.products.core.service.imp;

import com.brandonn.springboottemplate2.products.integration.database.InventoryRepository;
import com.brandonn.springboottemplate2.products.integration.database.entity.InventoryEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class InventoryServiceImpTests {
    private final InventoryRepository repository = Mockito.mock(InventoryRepository.class);

    private InventoryServiceImp service;

    private final List<InventoryEntity> inventoryEntities;

    private final List<InventoryEntity> updatedEntities;

    public InventoryServiceImpTests() {
        inventoryEntities = new ArrayList<>();
        InventoryEntity inventory1 = new InventoryEntity();
        var pk1 = new InventoryEntity.InventoryPKEntity();
        pk1.setProductId(1L);
        pk1.setWarehouseId(100L);
        inventory1.setInventoryPk(pk1);
        inventory1.setQuantity(5);

        InventoryEntity inventory2 = new InventoryEntity();
        var pk2 = new InventoryEntity.InventoryPKEntity();
        pk2.setProductId(1L);
        pk2.setWarehouseId(200L);
        inventory2.setInventoryPk(pk2);
        inventory2.setQuantity(2);

        inventoryEntities.add(inventory1);
        inventoryEntities.add(inventory2);

        updatedEntities = new ArrayList<>();
        InventoryEntity updated1 = new InventoryEntity();
        var uPk1 = new InventoryEntity.InventoryPKEntity();
        uPk1.setProductId(1L);
        uPk1.setWarehouseId(100L);
        updated1.setInventoryPk(uPk1);
        updated1.setQuantity(3);

        updatedEntities.add(updated1);
    }

    @BeforeEach
    public void init() {
        this.service = new InventoryServiceImp(repository);
    }

    @Test
    public void whenSubtractShouldReturnTrue() {
        // Request
        Map<Long, Integer> request = new HashMap<>();
        request.put(1L, 2);
        // Mock
        List<InventoryEntity> inventoryRows = new ArrayList<>();
        inventoryRows.add(inventoryEntities.get(0));
        when(repository.findAllByInventoryPk_ProductIdIn(request.keySet())).thenReturn(inventoryRows);
        List<InventoryEntity> updatedRows = new ArrayList<>();
        updatedRows.add(updatedEntities.get(0));
        when(repository.saveAll(updatedRows)).thenReturn(updatedRows);
        assertTrue(service.subtract(request));
    }

    @Test
    public void whenSubtractDoesntHaveEnoughShouldReturnFalse() {
        // Request
        Map<Long, Integer> request = new HashMap<>();
        request.put(1L, 10);
        // Mock
        List<InventoryEntity> inventoryRows = new ArrayList<>();
        inventoryRows.add(inventoryEntities.get(0));
        when(repository.findAllByInventoryPk_ProductIdIn(request.keySet())).thenReturn(inventoryRows);
        List<InventoryEntity> updatedRows = new ArrayList<>();
        updatedRows.add(updatedEntities.get(0));
        when(repository.saveAll(updatedRows)).thenReturn(updatedRows);
        assertFalse(service.subtract(request));
    }
}
