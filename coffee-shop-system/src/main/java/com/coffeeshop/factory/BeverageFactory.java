package com.coffeeshop.factory;

import com.coffeeshop.model.Beverage;
import com.coffeeshop.model.Size;

public interface BeverageFactory {
    Beverage createBeverage(Size size);
}