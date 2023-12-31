package com.brandonn.springboottemplate2.products.integration.database.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "INVENTORIES", schema = "OT")
public class InventoryEntity {
    @EmbeddedId
    private InventoryPKEntity inventoryPk;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Embeddable
    public static class InventoryPKEntity implements Serializable {
        @Column(name = "PRODUCT_ID")
        private Long productId;

        @Column(name = "WAREHOUSE_ID")
        private Long warehouseId;

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public Long getWarehouseId() {
            return warehouseId;
        }

        public void setWarehouseId(Long warehouseId) {
            this.warehouseId = warehouseId;
        }
    }

    public InventoryPKEntity getInventoryPk() {
        return inventoryPk;
    }

    public void setInventoryPk(InventoryPKEntity inventoryPk) {
        this.inventoryPk = inventoryPk;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public int hasRequiredQuantity(int requiredQuantity) {
        return this.quantity.compareTo(requiredQuantity);
    }

    public int decrementQuantity(int decrement) {
        this.quantity = this.quantity - decrement;
        return this.quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryEntity that = (InventoryEntity) o;
        return Objects.equals(inventoryPk, that.inventoryPk) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryPk, quantity);
    }
}
