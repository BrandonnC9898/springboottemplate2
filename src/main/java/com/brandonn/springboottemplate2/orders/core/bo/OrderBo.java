package com.brandonn.springboottemplate2.orders.core.bo;

import com.brandonn.springboottemplate2.orders.integration.database.entity.OrderEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderBo orderBo = (OrderBo) o;
        return Objects.equals(orderId, orderBo.orderId) && Objects.equals(customerId, orderBo.customerId) && Objects.equals(status, orderBo.status) && Objects.equals(salesmanId, orderBo.salesmanId) && Objects.equals(orderDate, orderBo.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerId, status, salesmanId, orderDate);
    }
}
