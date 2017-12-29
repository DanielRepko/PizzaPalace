package com.jordan.daniel.pizzapalace.JavaBean;

import java.util.ArrayList;

/**
 * Created by awsom on 12/29/2017.
 */

public class Pizza {
    private String name;
    private ArrayList<String> toppings;

    public Pizza(String name, ArrayList<String> toppings){
        this.name = name;
        this.toppings = toppings;
    }
}
