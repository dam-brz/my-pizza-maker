package com.dambrz.pizza.maker.calculation;

import com.dambrz.pizza.maker.model.Pizza;

interface CalculationStrategy {

    int calculate(Pizza pizza);
}
