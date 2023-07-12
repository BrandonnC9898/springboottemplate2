package com.brandonn.springboottemplate2.orders.core.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class CreateOrderPlacementRequestDto {
    @NotNull
    @PositiveOrZero
    private Long customerId;

    @NotNull
    private Long salesmanId;

    @NotNull
    private Date orderDate;

    private List<OrderItemRequestDto> items;
}
