package com.coffeeshop.dto;

import java.time.LocalDateTime;

public class OrderResponseDTO {
    private int orderNumber;
    private String description;
    private double price;
    private LocalDateTime orderDate;
    
    public OrderResponseDTO(int orderNumber, String description, double price, LocalDateTime orderDate) {
        this.orderNumber = orderNumber;
        this.description = description;
        this.price = price;
        this.orderDate = orderDate;
    }
    
    public int getOrderNumber() {
        return orderNumber;
    }
    
    public String getDescription() {
        return description;
    }
    
    public double getPrice() {
        return price;
    }
    
    public LocalDateTime getOrderDate() {
        return orderDate;
    }
}