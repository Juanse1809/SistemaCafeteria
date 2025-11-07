package com.coffeeshop.decorator;

import com.coffeeshop.model.Beverage;

public class WithCinnamon extends BeverageDecorator {
    public WithCinnamon(Beverage beverage) {
        super(beverage);
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Cinnamon";
    }
    
    @Override
    public double getPrice() {
        return beverage.getPrice() + 0.40;
    }
}