package com.dambrz.pizza.maker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PizzaMaker {
    public static void main(String[] args) {
        new PizzaMaker().start();
    }

    void start() {
        System.out.println("Welcome in Pizza Maker App!");

        addPizza();
    }

    private void addPizza() {
        try(Scanner in = new Scanner(System.in)) {
            System.out.println("Give me a pizza name");
            String pizzaName = getPizzaName(in, "Chief pizza");

            System.out.println("Which dough do you want? (CLASSIC, THICK_CRUST)");
            String doughValue = getDough(in, "CLASSIC");

            Dough dough = Dough.valueOf(doughValue);

            System.out.println("Which sauce do you want? (TOMATO, CHEESE, TOMATO-CHEESE)");
            Sauce sauce = getSauce(in);

            System.out.println("Give me the size of pizza (SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
            Size size = getSize(in);

            List<Topping> toppings = getToppings(in);

            Pizza pizza = new Pizza(pizzaName, dough, sauce, size, toppings);
            System.out.println(pizza);
        }
    }

    private List<Topping> getToppings(Scanner in) {
        List<Topping> toppings = new ArrayList<>();
        while (true) {
            System.out.println("Which topping do you want?");
            toppings.add(Topping.valueOf(in.nextLine()));

            System.out.println("More toppings? (YES/NO)");
            String nextTopping = in.nextLine();

            if (nextTopping.equals("NO")) {
                break;
            }
        }
        return toppings;
    }

    private Size getSize(Scanner in) {
        String sizeValue = in.nextLine();
        if (sizeValue.isBlank()) {
            sizeValue = "MEDIUM";
        }
        Size size = Size.valueOf(sizeValue);
        return size;
    }

    private Sauce getSauce(Scanner in) {
        String sauceValue = in.nextLine();
        if (sauceValue.isBlank()) {
            sauceValue = "TOMATO_CHEESE";
        }
        Sauce sauce = Sauce.valueOf(sauceValue);
        return sauce;
    }

    private String getDough(Scanner in, String classic) {
        String doughValue = in.nextLine();
        if (doughValue.isBlank()) {
            doughValue = classic;
        }
        return doughValue;
    }

    private String getPizzaName(Scanner in, String s) {
        String pizzaName = in.nextLine();
        if (pizzaName.isBlank()) {
            pizzaName = s;
        }
        return pizzaName;
    }
}
