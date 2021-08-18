package com.dambrz.pizza.maker;

import static com.dambrz.pizza.maker.PizzaPriceCalculatorUtils.getMeatToppingsPercentage;
import static com.dambrz.pizza.maker.Dough.THICK_CRUST;
import static com.dambrz.pizza.maker.Topping.PINEAPPLE;

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
