package com.coffeeshop.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private int orderNumber;
    private List<Beverage> beverages;
    private LocalDateTime orderDate;
    private double total;
    
    public Order(List<Beverage> beverages) {
        this.beverages = beverages;
        this.orderDate = LocalDateTime.now();
        this.total = beverages.stream().mapToDouble(Beverage::getPrice).sum();
    }
    
    public int getOrderNumber() {
        return orderNumber;
    }
    
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    public List<Beverage> getBeverages() {
        return beverages;
    }
    
    public LocalDateTime getOrderDate() {
        return orderDate;
    }
    
    public double getTotal() {
        return total;
    }
}