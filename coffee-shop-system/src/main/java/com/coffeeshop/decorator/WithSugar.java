package com.coffeeshop.decorator;

import com.coffeeshop.model.Beverage;

public class WithSugar extends BeverageDecorator {
    public WithSugar(Beverage beverage) {
        super(beverage);
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Sugar";
    }
    
    @Override
    public double getPrice() {
        return beverage.getPrice() + 0.20;
    }
}