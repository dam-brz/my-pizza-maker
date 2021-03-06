package com.dambrz.pizza.maker.calculation;

import com.dambrz.pizza.maker.model.Pizza;

class SmallPizzaCalculationStrategy implements CalculationStrategy{
    @Override
    public int calculate(Pizza pizza) {
        int price;
        if (pizza.getToppings().size() <= 2) {
            price = 18;
        } else {
            price = 22;
        }
        return price;
    }
}
