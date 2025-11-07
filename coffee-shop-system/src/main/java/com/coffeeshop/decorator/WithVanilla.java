package com.coffeeshop.decorator;

import com.coffeeshop.model.Beverage;

public class WithVanilla extends BeverageDecorator {
    public WithVanilla(Beverage beverage) {
        super(beverage);
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Vanilla";
    }
    
    @Override
    public double getPrice() {
        return beverage.getPrice() + 0.60;
    }
}