package com.coffeeshop.coffee_shop_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.coffeeshop")
public class CoffeeShopSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeShopSystemApplication.class, args);
    }
}