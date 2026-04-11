package com.example.demo.DTO;


import jakarta.validation.constraints.Min;

public class OrderRequest {
    private Long userId;
    private Long productId;

    @Min(value = 1, message = "Quantity must be greater than 0")
    private int quantity;

    public Long getUserId() { return userId; }
    public Long getProductId() { return productId; }
    public int getQuantity() { return quantity; }

    public void setUserId(Long userId) { this.userId = userId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}