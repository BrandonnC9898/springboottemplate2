package com.brandonn.springboottemplate2.products.core.service.imp;

import com.brandonn.springboottemplate2.products.core.service.InventoryService;
import com.brandonn.springboottemplate2.products.integration.database.InventoryRepository;
import com.brandonn.springboottemplate2.products.integration.database.entity.InventoryEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class InventoryServiceImp implements InventoryService {

    private final InventoryRepository repository;

    public InventoryServiceImp(InventoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean subtract(Map<Long, Integer> products) {
        var inventoryRows = repository.findAllByInventoryPk_ProductIdIn(products.keySet());
        if (inventoryRows.size() < products.keySet().size()) {
            return false;
        }
        List<InventoryEntity> updatedRows = new ArrayList<>();
        for (Long productId : products.keySet()) {
            int total = inventoryRows.stream().filter(i -> Objects.equals(i.getInventoryPk().getProductId(), productId))
                    .map(InventoryEntity::getQuantity)
                    .reduce(0, (totalQuantity, quantity) -> totalQuantity + quantity);
            if (total < products.get(productId)) {
                return false;
            }
            int productsLeft = products.get(productId);
            List<InventoryEntity> productsOfId = inventoryRows.stream().filter(i -> Objects.equals(i.getInventoryPk().getProductId(), productId))
                    .collect(Collectors.toList());
            for (InventoryEntity inventory : productsOfId) {
                if (inventory.hasRequiredQuantity(productsLeft) >= 0) {
                    inventory.decrementQuantity(productsLeft);
                    productsLeft = 0;
                    updatedRows.add(inventory);
                    break;
                } else {
                    productsLeft -= inventory.getQuantity();
                    inventory.setQuantity(0);
                    updatedRows.add(inventory);
                }
            }
        }
        repository.saveAll(updatedRows);
        return true;
    }
}
