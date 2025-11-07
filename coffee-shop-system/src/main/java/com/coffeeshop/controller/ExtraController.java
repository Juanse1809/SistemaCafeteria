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
@RequestMapping("/api/extras")
@CrossOrigin(origins = "http://localhost:3000")
public class ExtraController {
    
    @GetMapping
    public List<Map<String, Object>> getAllExtras() {
        return Arrays.asList(
            createExtra("milk", "Leche Extra", 500.0),
            createExtra("sugar", "Azúcar", 0.0),
            createExtra("cream", "Crema", 800.0),
            createExtra("syrup", "Jarabe de Vainilla", 600.0),
            createExtra("cinnamon", "Canela", 300.0)
        );
    }
    
    private Map<String, Object> createExtra(String id, String name, double price) {
        Map<String, Object> extra = new HashMap<>();
        extra.put("id", id);
        extra.put("name", name);
        extra.put("price", price);
        return extra;
    }
}