package com.example.demo.DTO;

public class OrderResponse {
    private String userName;
    private String productName;
    private int quantity;
    private double totalPrice;


    public String getUserName() { return userName; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getTotalPrice() { return totalPrice; }

    public void setUserName(String userName) { this.userName = userName; }
    public void setProductName(String productName) { this.productName = productName; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
}