package com.brandonn.springboottemplate2.orders.core.bo;

import com.brandonn.springboottemplate2.orders.integration.database.entity.OrderEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class OrderBo {
    private Long orderId;
    private Long customerId;
    private String status;
    private Long salesmanId;
    private LocalDate orderDate;

    public OrderBo(OrderEntity orderEntity) {
        this.orderId = orderEntity.getOrderId();
        this.customerId = orderEntity.getCustomerId();
        this.status = orderEntity.getStatus();
        this.salesmanId = orderEntity.getSalesmanId();
        this.orderDate = orderEntity.getOrderDate();
    }
}
