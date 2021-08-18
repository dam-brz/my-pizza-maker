package com.dambrz.pizza.maker;

import static com.dambrz.pizza.maker.Dough.THICK_CRUST;
class ExtraLargePizzaCalculationStrategy implements CalculationStrategy{

    @Override
    public int calculate(Pizza pizza) {
        int price;
        if (pizza.getToppings().size() <= 2) {
            price = 40;
        } else {
            price = 50;
        }

        if (pizza.getDough() == THICK_CRUST) {
            price +=10;
        }
        return price;
    }
}
