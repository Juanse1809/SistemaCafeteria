package com.coffeeshop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffeeshop.dto.BeverageRequestDTO;
import com.coffeeshop.dto.OrderResponseDTO;
import com.coffeeshop.service.BeverageService;

@RestController
@RequestMapping("/api/beverages")
@CrossOrigin(origins = "*")
public class BeverageController {
    
    @Autowired
    private BeverageService beverageService;
    
    @PostMapping("/create")
    public ResponseEntity<OrderResponseDTO> createBeverage(@RequestBody BeverageRequestDTO request) {
        try {
            OrderResponseDTO response = beverageService.createCustomOrder(request);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponseDTO>> getAllOrders() {
        return ResponseEntity.ok(beverageService.getAllOrders());
    }
    
    @GetMapping("/sales/total")
    public ResponseEntity<Map<String, Object>> getTotalSales() {
        Map<String, Object> response = new HashMap<>();
        response.put("totalSales", beverageService.getTotalSales());
        response.put("totalOrders", beverageService.getTotalOrders());
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/menu")
    public ResponseEntity<Map<String, Object>> getMenu() {
        Map<String, Object> menu = new HashMap<>();
        
        List<String> beverages = List.of("coffee", "tea", "hotchocolate");
        List<String> sizes = List.of("SMALL", "MEDIUM", "LARGE");
        List<String> extras = List.of("milk", "sugar", "cream", "vanilla", "cinnamon");
        
        menu.put("beverages", beverages);
        menu.put("sizes", sizes);
        menu.put("extras", extras);
        
        return ResponseEntity.ok(menu);
    }
}
