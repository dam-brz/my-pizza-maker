package com.dambrz.pizza.maker;

class PizzaPriceCalculator {

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
