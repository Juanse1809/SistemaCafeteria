package com.coffeeshop.factory;

import com.coffeeshop.model.Beverage;
import com.coffeeshop.model.Size;
import com.coffeeshop.model.Tea;

public class TeaFactory implements BeverageFactory {
    @Override
    public Beverage createBeverage(Size size) {
        return new Tea(size);
    }
}