package com.training.petru.decorator;

import java.math.BigDecimal;

public abstract class BeverageCondiments extends Beverage{
    Beverage beverage;

    public BeverageCondiments(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return "Condiments";
    }

    @Override
    public BigDecimal cost() {
        return super.cost();
    }
}
