package com.dambrz.pizza.maker.calculation;

import com.dambrz.pizza.maker.model.Pizza;

import static com.dambrz.pizza.maker.calculation.PizzaPriceCalculatorUtils.getMeatToppingsPercentage;
import static com.dambrz.pizza.maker.model.Dough.THICK_CRUST;
import static com.dambrz.pizza.maker.model.Topping.PINEAPPLE;

class LargePizzaCalculationStrategy implements CalculationStrategy{
    @Override
    public int calculate(Pizza pizza) {
        int price;
        if (pizza.getToppings().size() <= 3) {
            if (getMeatToppingsPercentage(pizza.getToppings()) < 40) {
                price = 30;
            } else {
                price = 35;
            }
        } else {
            if (pizza.getToppings().contains(PINEAPPLE)) {
                price = 37;
            } else {
                price = 40;
            }
        }

        if (pizza.getDough() == THICK_CRUST) {
            price += 5;
        }
        return price;
    }
}
