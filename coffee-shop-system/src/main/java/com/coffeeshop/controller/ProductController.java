package com.coffeeshop.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    
    @GetMapping
    public List<Map<String, Object>> getAllProducts() {
        return Arrays.asList(
            createProduct(1, "Café Americano", 2500.0, "Café"),
            createProduct(2, "Café Latte", 3500.0, "Café"),
            createProduct(3, "Cappuccino", 3800.0, "Café"),
            createProduct(4, "Espresso", 2000.0, "Café"),
            createProduct(5, "Mocha", 4000.0, "Café"),
            createProduct(6, "Té Verde", 2200.0, "Té"),
            createProduct(7, "Té Negro", 2200.0, "Té"),
            createProduct(8, "Chocolate Caliente", 3000.0, "Otros")
        );
    }
    
    private Map<String, Object> createProduct(int id, String name, double price, String category) {
        Map<String, Object> product = new HashMap<>();
        product.put("id", id);
        product.put("name", name);
        product.put("price", price);
        product.put("category", category);
        return product;
    }
}