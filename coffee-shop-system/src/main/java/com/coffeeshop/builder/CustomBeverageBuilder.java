package com.coffeeshop.builder;

import com.coffeeshop.decorator.WithCinnamon;
import com.coffeeshop.decorator.WithCream;
import com.coffeeshop.decorator.WithMilk;
import com.coffeeshop.decorator.WithSugar;
import com.coffeeshop.decorator.WithVanilla;
import com.coffeeshop.factory.BeverageFactory;
import com.coffeeshop.factory.CoffeeFactory;
import com.coffeeshop.factory.HotChocolateFactory;
import com.coffeeshop.factory.TeaFactory;
import com.coffeeshop.model.Beverage;
import com.coffeeshop.model.Size;

public class CustomBeverageBuilder {
    private Beverage beverage;
    
    public CustomBeverageBuilder(String beverageType, Size size) {
        BeverageFactory factory;
        
        switch (beverageType.toLowerCase()) {
            case "coffee":
                factory = new CoffeeFactory();
                break;
            case "tea":
                factory = new TeaFactory();
                break;
            case "hotchocolate":
                factory = new HotChocolateFactory();
                break;
            default:
                throw new IllegalArgumentException("Invalid beverage type: " + beverageType);
        }
        
        this.beverage = factory.createBeverage(size);
    }
    
    public CustomBeverageBuilder withMilk() {
        this.beverage = new WithMilk(this.beverage);
        return this;
    }
    
    public CustomBeverageBuilder withSugar() {
        this.beverage = new WithSugar(this.beverage);
        return this;
    }
    
    public CustomBeverageBuilder withCream() {
        this.beverage = new WithCream(this.beverage);
        return this;
    }
    
    public CustomBeverageBuilder withVanilla() {
        this.beverage = new WithVanilla(this.beverage);
        return this;
    }
    
    public CustomBeverageBuilder withCinnamon() {
        this.beverage = new WithCinnamon(this.beverage);
        return this;
    }
    
    public Beverage build() {
        return this.beverage;
    }
}