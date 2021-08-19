package com.dambrz.pizza.maker.calculation;

import com.dambrz.pizza.maker.model.Topping;

import java.util.List;

class PizzaPriceCalculatorUtils {
    static double getMeatToppingsPercentage(List<Topping> toppings) {
        long count = toppings.stream()
                .filter(Topping::isMeat)
                .count();

        return ((double) count/(double) toppings.size()) * 100;
    }
}
