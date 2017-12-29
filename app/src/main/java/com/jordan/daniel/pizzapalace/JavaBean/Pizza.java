package com.jordan.daniel.pizzapalace.JavaBean;

import java.util.ArrayList;

/**
 * This object is used to bring information from the Pizza
 * ListView page over to the Order page.
 */

public class Pizza {
    private String name;
    private ArrayList<String> toppings;

    public Pizza(){}

    public Pizza(String name, ArrayList<String> toppings){
        this.name = name;
        this.toppings = toppings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<String> toppings) {
        this.toppings = toppings;
    }
}
