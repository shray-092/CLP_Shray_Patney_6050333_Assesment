package com.example.demo.Controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.DTO.OrderRequest;
import com.example.demo.DTO.OrderResponse;
import com.example.demo.service.Orderservice;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private Orderservice orderservice;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(
            @Valid @RequestBody OrderRequest request) {
        return ResponseEntity.ok(orderservice.createOrder(request));
    }
}