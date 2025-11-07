package com.coffeeshop.decorator;

import com.coffeeshop.model.Beverage;

public abstract class BeverageDecorator implements Beverage {
    protected Beverage beverage;
    
    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription();
    }
    
    @Override
    public double getPrice() {
        return beverage.getPrice();
    }
}