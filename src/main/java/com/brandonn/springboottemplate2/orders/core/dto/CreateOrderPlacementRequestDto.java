package com.brandonn.springboottemplate2.orders.core.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class CreateOrderPlacementRequestDto {
    private Long customerId;
    private Long salesmanId;
    private LocalDate orderDate;
    private List<OrderItemRequestDto> items;
}
