package com.dambrz.pizza.maker;

class PizzaPriceCalculator {

    private final Pizza pizza;
    private final SwitchCalculationStrategyResolver switchcalculationStrategyResolver;

    public PizzaPriceCalculator(Pizza pizza, SwitchCalculationStrategyResolver switchcalculationStrategyResolver) {
        this.pizza = pizza;
        this.switchcalculationStrategyResolver = switchcalculationStrategyResolver;
    }

    public int calculatePizzaPrice() {
        CalculationStrategy calculationStrategy = switchcalculationStrategyResolver.chooseStrategy(pizza.getSize());

        int price = calculationStrategy.calculate(pizza);
        System.out.println("Price: " + price);
        return price;
    }
}
