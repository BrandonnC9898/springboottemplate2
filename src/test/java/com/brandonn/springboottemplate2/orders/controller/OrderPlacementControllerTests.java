package com.brandonn.springboottemplate2.orders.controller;

import com.brandonn.springboottemplate2.orders.core.dto.CreateOrderPlacementRequestDto;
import com.brandonn.springboottemplate2.orders.core.dto.OrderItemRequestDto;
import com.brandonn.springboottemplate2.orders.core.service.OrderPlacementService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = OrderPlacementController.class)
public class OrderPlacementControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private OrderPlacementService service;

    @Test
    public void GivenValidBody_WhenCreate_ThenReturnsCreated() throws Exception {
        var requestBody = new CreateOrderPlacementRequestDto();
        var item = new OrderItemRequestDto();
        item.setProductId(2L);
        item.setQuantity(2);
        var items = new ArrayList<OrderItemRequestDto>();
        items.add(item);
        requestBody.setCustomerId(1L);
        requestBody.setSalesmanId(1L);
        requestBody.setOrderDate("26-06-2023");
        requestBody.setItems(items);
        mockMvc.perform(post("/order/placement").contentType("application/json").content(objectMapper.writeValueAsString(requestBody))).andExpect(status().isCreated());
    }
}
