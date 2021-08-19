package com.dambrz.pizza.maker;

import com.dambrz.pizza.maker.calculation.PizzaPriceCalculator;
import com.dambrz.pizza.maker.calculation.SwitchCalculationStrategyResolver;
import com.dambrz.pizza.maker.model.Pizza;
import com.dambrz.pizza.maker.model.PizzaBuilder;
import com.dambrz.pizza.maker.model.Topping;

import java.util.Scanner;

public class PizzaMaker {
    public static void main(String[] args) {
        new PizzaMaker().start();
    }

    void start() {
        System.out.println("Welcome in Pizza Maker App!");

        var pizza = createPizza();

        PizzaPriceCalculator pizzaPriceCalculator = new PizzaPriceCalculator(pizza, new SwitchCalculationStrategyResolver());
        pizzaPriceCalculator.calculatePizzaPrice();
    }

    private Pizza createPizza() {
        try(Scanner in = new Scanner(System.in)) {
            PizzaBuilder pizzaBuilder = new PizzaBuilder();

            System.out.println("Give me a pizza name");
            pizzaBuilder.withName(in.nextLine());

            System.out.println("Which dough do you want? (CLASSIC, THICK_CRUST)");
            pizzaBuilder.withDough(in.nextLine());

            System.out.println("Which sauce do you want? (TOMATO, CHEESE, TOMATO-CHEESE)");
            pizzaBuilder.withSauce(in.nextLine());

            System.out.println("Give me the size of pizza (SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
            pizzaBuilder.withSize(in.nextLine());

            getToppings(in, pizzaBuilder);

            Pizza pizza = pizzaBuilder.build();
            System.out.println(pizza);

            return pizza;
        }
    }

    private void getToppings(Scanner in, PizzaBuilder pizzaBuilder) {
        while (true) {
            System.out.println("Which topping do you want?");
            pizzaBuilder.withTopping(Topping.valueOf(in.nextLine()));

            System.out.println("More toppings? (YES/NO)");

            if (in.nextLine().equals("NO")) {
                break;
            }
        }
    }


}
