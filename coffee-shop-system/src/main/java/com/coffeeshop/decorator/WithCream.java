package com.coffeeshop.decorator;

import com.coffeeshop.model.Beverage;

public class WithCream extends BeverageDecorator {
    public WithCream(Beverage beverage) {
        super(beverage);
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Cream";
    }
    
    @Override
    public double getPrice() {
        return beverage.getPrice() + 0.80;
    }
}