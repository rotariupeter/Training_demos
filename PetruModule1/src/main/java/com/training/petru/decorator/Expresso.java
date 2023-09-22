package com.training.petru.decorator;

import java.math.BigDecimal;

public class Expresso extends Beverage{
    @Override
    public String getDescription() {
        return "Its Expresso";
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal("0.7");
    }
}
