package com.brandonn.springboottemplate2.orders.controller;

import com.brandonn.springboottemplate2.orders.core.dto.CreateOrderPlacementRequestDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order/placement")
@Slf4j
public class OrderPlacementController {

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody @Valid CreateOrderPlacementRequestDto request) {
        log.info("create request: {}", request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
