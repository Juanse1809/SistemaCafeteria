package com.coffeeshop.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:8080")
public class OrderController {
    
    // Simulación de base de datos en memoria
    private List<Map<String, Object>> orders = new ArrayList<>();
    private int orderIdCounter = 1;
    
    @PostMapping
    public ResponseEntity<Map<String, Object>> createOrder(@RequestBody Map<String, Object> orderData) {
        Map<String, Object> order = new HashMap<>();
        order.put("id", orderIdCounter++);
        order.put("items", orderData.get("items"));
        order.put("total", orderData.get("total"));
        order.put("status", "CONFIRMED");
        order.put("createdAt", LocalDateTime.now().toString());
        
        orders.add(order);
        
        System.out.println("✅ Nueva orden creada: #" + order.get("id"));
        System.out.println("   Total: $" + order.get("total"));
        
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getOrderById(@PathVariable int id) {
        Optional<Map<String, Object>> order = orders.stream()
            .filter(o -> o.get("id").equals(id))
            .findFirst();
        
        return order.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllOrders() {
        return ResponseEntity.ok(orders);
    }
}