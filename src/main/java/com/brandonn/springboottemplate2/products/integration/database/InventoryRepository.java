package com.brandonn.springboottemplate2.products.integration.database;

import com.brandonn.springboottemplate2.products.integration.database.entity.InventoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface InventoryRepository extends CrudRepository<InventoryEntity, InventoryEntity.InventoryPKEntity> {
    List<InventoryEntity> findAllByProductId(Set<Long> productIds);
}
