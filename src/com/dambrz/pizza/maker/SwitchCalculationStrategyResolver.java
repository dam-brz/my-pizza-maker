package com.dambrz.pizza.maker;

class SwitchCalculationStrategyResolver  implements CalculationStrategyResolver {

    @Override
    public CalculationStrategy chooseStrategy(Size size) {
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
