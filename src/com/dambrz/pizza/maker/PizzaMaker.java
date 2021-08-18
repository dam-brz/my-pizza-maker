package com.dambrz.pizza.maker;

import java.util.List;
import java.util.Scanner;

import static com.dambrz.pizza.maker.Dough.THICK_CRUST;
import static com.dambrz.pizza.maker.Topping.PINEAPPLE;

public class PizzaMaker {
    public static void main(String[] args) {
        new PizzaMaker().start();
    }

    void start() {
        System.out.println("Welcome in Pizza Maker App!");

        var pizza = createPizza();

        calculatePrice(pizza);
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

    private static double getMeatToppingsPercentage(List<Topping> toppings) {
        long count = toppings.stream()
                .filter(Topping::isMeat)
                .count();

        return ((double) count/(double) toppings.size()) * 100;
    }

    private int calculatePrice(Pizza pizza) {
        Size size = pizza.getSize();
        int price = 0;

        switch (size) {
            case SMALL:
                price = calculatePriceForSmallPizza(pizza);
                break;
            case MEDIUM:
                price = calculatePriceForMediumPizza(pizza);
                break;
            case LARGE:
                price = calculatePriceForLargePizza(pizza);
                break;
            case EXTRA_LARGE:
                price = calculatePriceForExtraLargePizza(pizza);
                break;
            default:
                throw new IllegalStateException("Unknown size=" + size);
        }

        System.out.println("Price: " + price);
        return price;
    }

    private int calculatePriceForSmallPizza(Pizza pizza) {
        int price;
        if (pizza.getToppings().size() <= 2) {
            price = 18;
        } else {
            price = 22;
        }
        return price;
    }

    private int calculatePriceForMediumPizza(Pizza pizza) {
        int price;
        if (pizza.getToppings().size() <= 3) {
            if (getMeatToppingsPercentage(pizza.getToppings()) < 50) {
                price = 25;
            } else {
                price = 27;
            }
        } else {
            if (getMeatToppingsPercentage(pizza.getToppings()) < 40) {
                price = 27;
            } else {
                price = 29;
            }
        }
        return price;
    }

    private int calculatePriceForLargePizza(Pizza pizza) {
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

    private int calculatePriceForExtraLargePizza(Pizza pizza) {
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
