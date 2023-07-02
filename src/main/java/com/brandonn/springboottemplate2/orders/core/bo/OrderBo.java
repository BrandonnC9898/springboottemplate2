package com.brandonn.springboottemplate2.orders.core.bo;

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
}
