package com.coffeeshop.decorator;

import com.coffeeshop.model.Beverage;

public class WithMilk extends BeverageDecorator {
    public WithMilk(Beverage beverage) {
        super(beverage);
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Milk";
    }
    
    @Override
    public double getPrice() {
        return beverage.getPrice() + 0.50;
    }
}