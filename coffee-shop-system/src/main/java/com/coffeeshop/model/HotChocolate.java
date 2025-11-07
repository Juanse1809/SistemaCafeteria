package com.coffeeshop.model;

public class HotChocolate extends BaseBeverage {
    public HotChocolate(Size size) {
        super(size);
        this.description = "Hot Chocolate";
        this.basePrice = 3.00;
    }
}