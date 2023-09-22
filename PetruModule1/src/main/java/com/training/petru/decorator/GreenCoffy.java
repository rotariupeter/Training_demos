package com.training.petru.decorator;

import java.math.BigDecimal;

public class GreenCoffy extends BeverageCondiments{

    public GreenCoffy(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public BigDecimal cost() {
        return beverage.cost().add(new BigDecimal("2.122"));
    }
}
