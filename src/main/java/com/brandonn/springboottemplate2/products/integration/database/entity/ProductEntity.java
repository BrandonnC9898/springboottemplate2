package com.brandonn.springboottemplate2.products.integration.database.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCTS", schema = "OT")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "LIST_PRICE")
    private BigDecimal listPrice;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }
}
