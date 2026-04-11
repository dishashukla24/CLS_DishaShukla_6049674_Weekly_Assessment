package com.example.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.orderservice.dto.OrderResponse;
import com.example.orderservice.dto.ProductDTO;
import com.example.orderservice.dto.UserDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class OrderService {

    @Autowired
    private RestTemplate restTemplate;

    // 🔥 MAIN METHOD WITH CIRCUIT BREAKER
    @CircuitBreaker(name = "orderService", fallbackMethod = "fallbackOrder")
    public OrderResponse createOrder(Long userId, Long productId, int quantity) {

        if (quantity <= 0) {
            throw new RuntimeException("Quantity must be > 0");
        }


        UserDTO user = restTemplate.getForObject(
                "http://localhost:8081/users/" + userId,
                UserDTO.class
        );

        if (user == null) {
            throw new RuntimeException("User not found");
        }

      
        ProductDTO product = restTemplate.getForObject(
                "http://localhost:8082/products/" + productId,
                ProductDTO.class
        );

        if (product == null) {
            throw new RuntimeException("Product not found");
        }

        double total = product.getPrice() * quantity;

        return new OrderResponse(
                5001L,
                user.getName(),
                product.getName(),
                quantity,
                total
        );
    }

  
    public OrderResponse fallbackOrder(Long userId, Long productId, int quantity, Exception ex) {

        return new OrderResponse(
                0L,
                "Service Unavailable",
                "Product/User Service Down",
                quantity,
                0.0
        );
    }
}