package com.coffeeshop.model;

public abstract class BaseBeverage implements Beverage {
    protected String description;
    protected double basePrice;
    protected Size size;
    
    public BaseBeverage(Size size) {
        this.size = size;
    }
    
    @Override
    public String getDescription() {
        return description + " (" + size + ")";
    }
    
    @Override
    public double getPrice() {
        return basePrice * size.getMultiplier();
    }
}