package com.dambrz.pizza.maker;

import java.util.ArrayList;
import java.util.List;

class PizzaBuilder {
    private String pizzaName;
    private Size size;
    private Sauce sauce;
    private Dough dough;
    private List<Topping> toppings = new ArrayList<>();

    public void withName(String pizzaName) {
        this.pizzaName = pizzaName.isBlank() ? "Mine pizza" : pizzaName;
    }

    public void withSize(String sizeValue) {
        this.size = Size.valueOf(sizeValue.isBlank() ? "MEDIUM" : sizeValue);
    }

    public void withSauce(String sauceValue) {
        this.sauce = Sauce.valueOf(sauceValue.isBlank() ? "TOMATO_CHEESE" : sauceValue);
    }

    public void withDough(String doughValue) {
        this.dough = Dough.valueOf(doughValue.isBlank() ? "CLASSIC" : doughValue);
    }

    public void withTopping(Topping topping) {
        toppings.add(topping);
    }


    public Pizza build() {
        return new Pizza(pizzaName, dough, sauce, size, List.copyOf(toppings));
    }
}
