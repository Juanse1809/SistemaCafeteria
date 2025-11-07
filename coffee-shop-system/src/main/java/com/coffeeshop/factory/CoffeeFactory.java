package com.coffeeshop.factory;

import com.coffeeshop.model.Beverage;
import com.coffeeshop.model.Coffee;
import com.coffeeshop.model.Size;

public class CoffeeFactory implements BeverageFactory {
    @Override
    public Beverage createBeverage(Size size) {
        return new Coffee(size);
    }
}