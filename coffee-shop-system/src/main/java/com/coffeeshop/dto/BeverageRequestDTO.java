package com.coffeeshop.dto;

import com.coffeeshop.model.Size;

public class BeverageRequestDTO {
    private String beverageType;
    private Size size;
    private boolean withMilk;
    private boolean withSugar;
    private boolean withCream;
    private boolean withVanilla;
    private boolean withCinnamon;
    
    public String getBeverageType() {
        return beverageType;
    }
    
    public void setBeverageType(String beverageType) {
        this.beverageType = beverageType;
    }
    
    public Size getSize() {
        return size;
    }
    
    public void setSize(Size size) {
        this.size = size;
    }
    
    public boolean isWithMilk() {
        return withMilk;
    }
    
    public void setWithMilk(boolean withMilk) {
        this.withMilk = withMilk;
    }
    
    public boolean isWithSugar() {
        return withSugar;
    }
    
    public void setWithSugar(boolean withSugar) {
        this.withSugar = withSugar;
    }
    
    public boolean isWithCream() {
        return withCream;
    }
    
    public void setWithCream(boolean withCream) {
        this.withCream = withCream;
    }
    
    public boolean isWithVanilla() {
        return withVanilla;
    }
    
    public void setWithVanilla(boolean withVanilla) {
        this.withVanilla = withVanilla;
    }
    
    public boolean isWithCinnamon() {
        return withCinnamon;
    }
    
    public void setWithCinnamon(boolean withCinnamon) {
        this.withCinnamon = withCinnamon;
    }
}