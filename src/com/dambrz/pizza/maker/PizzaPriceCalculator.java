package com.dambrz.pizza.maker;

class PizzaPriceCalculator {

    private final Pizza pizza;

    public PizzaPriceCalculator(Pizza pizza) {
        this.pizza = pizza;
    }

    public int calculatePizzaPrice() {
        CalculationStrategy calculationStrategy = chooseStrategy(pizza.getSize());

        int price = calculationStrategy.calculate(pizza);
        System.out.println("Price: " + price);
        return price;
    }

    private CalculationStrategy chooseStrategy(Size size) {
        switch (size) {
            case SMALL:
                return new SmallPizzaCalculationStrategy();
            case MEDIUM:
                return new MediumPizzaCalculationStrategy();
            case LARGE:
                return new LargePizzaCalculationStrategy();
            case EXTRA_LARGE:
                return new ExtraLargePizzaCalculationStrategy();
            default:
                throw new IllegalStateException("Unknown size=" + size);
        }
    }
}
