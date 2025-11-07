package com.coffeeshop.model;

public class Coffee extends BaseBeverage {
    public Coffee(Size size) {
        super(size);
        this.description = "Coffee";
        this.basePrice = 2.50;
    }
}