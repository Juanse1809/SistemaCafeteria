package com.coffeeshop.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.coffeeshop.builder.CustomBeverageBuilder;
import com.coffeeshop.dto.BeverageRequestDTO;
import com.coffeeshop.dto.OrderResponseDTO;
import com.coffeeshop.model.Beverage;
import com.coffeeshop.model.Order;
import com.coffeeshop.singleton.OrderManager;

@Service
public class BeverageService {
    
    public OrderResponseDTO createCustomOrder(BeverageRequestDTO request) {
        CustomBeverageBuilder builder = new CustomBeverageBuilder(
            request.getBeverageType(),
            request.getSize()
        );
        
        if (request.isWithMilk()) builder.withMilk();
        if (request.isWithSugar()) builder.withSugar();
        if (request.isWithCream()) builder.withCream();
        if (request.isWithVanilla()) builder.withVanilla();
        if (request.isWithCinnamon()) builder.withCinnamon();
        
        Beverage beverage = builder.build();
        
        Order order = new Order(Collections.singletonList(beverage));
        int orderNumber = OrderManager.getInstance().addOrder(order);
        
        return new OrderResponseDTO(
            orderNumber,
            beverage.getDescription(),
            beverage.getPrice(),
            order.getOrderDate()
        );
    }
    
    public List<OrderResponseDTO> getAllOrders() {
        return OrderManager.getInstance().getAllOrders().stream()
            .map(order -> new OrderResponseDTO(
                order.getOrderNumber(),
                order.getBeverages().get(0).getDescription(),
                order.getTotal(),
                order.getOrderDate()
            ))
            .collect(Collectors.toList());
    }
    
    public double getTotalSales() {
        return OrderManager.getInstance().calculateTotalSales();
    }
    
    public int getTotalOrders() {
        return OrderManager.getInstance().getTotalOrders();
    }
}