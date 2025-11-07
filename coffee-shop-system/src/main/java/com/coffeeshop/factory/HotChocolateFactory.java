package com.coffeeshop.factory;

import com.coffeeshop.model.Beverage;
import com.coffeeshop.model.HotChocolate;
import com.coffeeshop.model.Size;

public class HotChocolateFactory implements BeverageFactory {
    @Override
    public Beverage createBeverage(Size size) {
        return new HotChocolate(size);
    }
}