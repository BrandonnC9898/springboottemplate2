package com.brandonn.springboottemplate2.orders.core.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItemRequestDto {
    private Long productId;
    private Integer quantity;
}
