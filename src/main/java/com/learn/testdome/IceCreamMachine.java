package com.learn.testdome;

import java.util.ArrayList;
import java.util.List;

public class IceCreamMachine {
    public String[] ingredients;
    public String[] toppings;

    public static class IceCream {
        public String ingredient;
        public String topping;

        public IceCream(String ingredient, String topping) {
            this.ingredient = ingredient;
            this.topping = topping;
        }
    }

    public IceCreamMachine(String[] ingredeints, String[] toppings) {
        this.ingredients = ingredeints;
        this.toppings = toppings;
    }

    public List<IceCream> scoops() {
        //throw new UnsupportedOperationException("Waiting to be implemented");
        List<IceCream> iceCreamList = new ArrayList<>();
        for (String ingredient : ingredients) {//Learn for each loop
            for (String topping : toppings) {
                iceCreamList.add(new IceCream(ingredient, topping));
            }
        }
        return iceCreamList;
    }

    public static void main(String[] args) {
        IceCreamMachine machine = new IceCreamMachine(new String[]{
                "vanilla", "chocolate"
        }, new String[]{
                "chocolate sauce"
        });

        List<IceCream> scoops = machine.scoops();
        System.out.println(scoops.size());

        /*
         * Should print:
         * vanilla, chocolate sauce
         * chocolate, chocolate sauce
         */
        for (IceCream iceCream : scoops) {
            System.out.println(iceCream.ingredient + ", " + iceCream.topping);
        }
    }
}
