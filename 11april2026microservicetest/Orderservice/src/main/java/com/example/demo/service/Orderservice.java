package com.example.demo.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.DTO.OrderRequest;
import com.example.demo.DTO.OrderResponse;
import com.example.demo.DTO.ProductDTO;
import com.example.demo.DTO.UserDto;

@Service
public class Orderservice {

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "orderService", fallbackMethod = "fallbackOrder")
    public OrderResponse createOrder(OrderRequest request) {

        UserDto user = restTemplate.getForObject(
            "http://USERSERVICE/users/" + request.getUserId(),
            UserDto.class
        );

        ProductDTO product = restTemplate.getForObject(
            "http://PRODUCTSERVICE/products/" + request.getProductId(),
            ProductDTO.class
        );

        if (user == null) throw new RuntimeException("User not found");
        if (product == null) throw new RuntimeException("Product not found");

        double total = product.getPrice() * request.getQuantity();

        OrderResponse response = new OrderResponse();
        response.setUserName(user.getName());
        response.setProductName(product.getName());
        response.setQuantity(request.getQuantity());
        response.setTotalPrice(total);

        return response;
    }

    public OrderResponse fallbackOrder(OrderRequest request, Throwable t) {
        OrderResponse response = new OrderResponse();
        response.setUserName("Service Down");
        response.setProductName("Service Down");
        response.setQuantity(0);
        response.setTotalPrice(0);
        return response;
    }
}