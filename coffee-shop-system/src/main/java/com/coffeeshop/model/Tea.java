package com.coffeeshop.model;

public class Tea extends BaseBeverage {
    public Tea(Size size) {
        super(size);
        this.description = "Tea";
        this.basePrice = 2.00;
    }
}