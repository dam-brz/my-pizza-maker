package com.dambrz.pizza.maker;

interface CalculationStrategyResolver {
    CalculationStrategy chooseStrategy(Size size);
}
