package com.example.orderservice.controller;

import com.example.orderservice.dto.OrderResponse;
import com.example.orderservice.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.orderservice.dto.OrderRequest;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public OrderResponse createOrder(@RequestBody OrderRequest request) {
        return service.createOrder(
                request.getUserId(),
                request.getProductId(),
                request.getQuantity()
        );
    }
}