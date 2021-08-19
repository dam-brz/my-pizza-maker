package com.dambrz.pizza.maker.calculation;

import com.dambrz.pizza.maker.model.Size;

interface CalculationStrategyResolver {
    CalculationStrategy chooseStrategy(Size size);
}
