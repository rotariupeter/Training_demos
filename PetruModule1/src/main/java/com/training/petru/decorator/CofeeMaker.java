package com.training.petru.decorator;

public class CofeeMaker {
    public static void main(String[] args) {
        Beverage expresso = new Expresso();

        BeverageCondiments beverageCondiments = new Milk(expresso);
        beverageCondiments = new GreenCoffy(beverageCondiments);
        System.out.println(beverageCondiments.cost().doubleValue());

    }
}
