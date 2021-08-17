package com.dambrz.pizza.maker;

import java.util.ArrayList;
import java.util.List;

class Pizza {
    private final String name;
    private final Dough dough;
    private final Sauce sauce;
    private final Size size;
    private final List<Topping> toppings;

    public Pizza(String name, Dough dough, Sauce sauce, Size size, List<Topping> toppings) {
        this.name = name;
        this.dough = dough;
        this.sauce = sauce;
        this.size = size;
        this.toppings = List.copyOf(toppings);
    }

    public String getName() {
        return name;
    }

    public Dough getDough() {
        return dough;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public Size getSize() {
        return size;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", dough='" + dough + '\'' +
                ", sauce='" + sauce + '\'' +
                ", size='" + size + '\'' +
                ", toppings=" + toppings +
                '}';
    }
}
