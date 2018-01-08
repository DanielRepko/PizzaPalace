package com.jordan.daniel.pizzapalace.JavaBean;

import java.util.ArrayList;


/**
 * @author Daniel Repko
 *
 * PizzaList extends ArrayList and is meant to be used
 * to access all of the preset pizzas
 */
public class PizzaList extends ArrayList {

    private ArrayList<String> toppings;

    public PizzaList(){

    }

    /**
     * This method is to be called inside of the constructor and
     * is used to fill the toppings ArrayList
     */
    private void fillToppings(){
        this.toppings.add("Pepperoni");
        this.toppings.add("Bacon");
        this.toppings.add("Ham");
        this.toppings.add("Pineapple");
        this.toppings.add("Hamburger");
        this.toppings.add("Mushrooms");
        this.toppings.add("Anchovies");
        this.toppings.add("Green Olives");
        this.toppings.add("Black Olives");
        this.toppings.add("Peppers");
        this.toppings.add("Onions");
        this.toppings.add("Sausage");
        this.toppings.add("Spinach");
        this.toppings.add("Extra Cheese");
    }
}
