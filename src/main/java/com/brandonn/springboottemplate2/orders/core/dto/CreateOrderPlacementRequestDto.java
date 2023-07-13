package com.brandonn.springboottemplate2.orders.core.dto;

import com.brandonn.springboottemplate2.shared.annotation.ValidDateFormat;
import com.brandonn.springboottemplate2.shared.utils.DateUtils;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    @ValidDateFormat
    private String orderDate;

    private List<OrderItemRequestDto> items;

    public LocalDate getOrderDateAsLocalDate() {
        return DateUtils.parseDate(this.orderDate);
    }
}
