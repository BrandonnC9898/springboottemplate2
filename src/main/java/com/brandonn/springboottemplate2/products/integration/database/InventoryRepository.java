package com.brandonn.springboottemplate2.products.integration.database;

import com.brandonn.springboottemplate2.products.integration.database.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface InventoryRepository extends JpaRepository<InventoryEntity, InventoryEntity.InventoryPKEntity> {
    List<InventoryEntity> findAllByInventoryPk_ProductIdIn(Set<Long> productIds);
}
