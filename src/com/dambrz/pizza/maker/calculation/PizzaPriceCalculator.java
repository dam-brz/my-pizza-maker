package com.dambrz.pizza.maker.calculation;

import com.dambrz.pizza.maker.model.Pizza;

public class PizzaPriceCalculator {

    private final Pizza pizza;
    private final CalculationStrategyResolver calculationStrategyResolver;

    public PizzaPriceCalculator(Pizza pizza, CalculationStrategyResolver calculationStrategyResolver) {
        this.pizza = pizza;
        this.calculationStrategyResolver = calculationStrategyResolver;
    }

    public int calculatePizzaPrice() {
        CalculationStrategy calculationStrategy = calculationStrategyResolver.chooseStrategy(pizza.getSize());

        int price = calculationStrategy.calculate(pizza);
        System.out.println("Price: " + price);
        return price;
    }
}
