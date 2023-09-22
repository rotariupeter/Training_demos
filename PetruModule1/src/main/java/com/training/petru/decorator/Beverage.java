package com.training.petru.decorator;

import java.math.BigDecimal;

public abstract class Beverage {

    String description;

    public String getDescription(){
        return "no description...";
    }


    public BigDecimal cost(){
        return new BigDecimal("0");
    }

}
