package com.coffeeshop.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.coffeeshop.model.Order;

public class OrderManager {
    private static OrderManager instance;
    private final List<Order> orders;
    private final AtomicInteger orderCounter;
    
    private OrderManager() {
        this.orders = new ArrayList<>();
        this.orderCounter = new AtomicInteger(1);
    }
    
    public static synchronized OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }
    
    public int addOrder(Order order) {
        int orderNumber = orderCounter.getAndIncrement();
        order.setOrderNumber(orderNumber);
        orders.add(order);
        return orderNumber;
    }
    
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }
    
    public Order getOrder(int orderNumber) {
        return orders.stream()
            .filter(o -> o.getOrderNumber() == orderNumber)
            .findFirst()
            .orElse(null);
    }
    
    public double calculateTotalSales() {
        return orders.stream()
            .mapToDouble(Order::getTotal)
            .sum();
    }
    
    public int getTotalOrders() {
        return orders.size();
    }
}