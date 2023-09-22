package com.training.petru.decorator;

import java.math.BigDecimal;

public class Milk extends BeverageCondiments{
    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return "Milk";
    }

    @Override
    public BigDecimal cost() {
        return beverage.cost().add(new BigDecimal("3.23"));
    }

}
