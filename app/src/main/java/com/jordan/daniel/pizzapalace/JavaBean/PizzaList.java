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
        fillToppings();

        //creating Pizza object for Meat Lover's and adding it to PizzaList
        ArrayList<String> meatLoversPizza = new ArrayList<String>();
        meatLoversPizza.add(this.toppings.get(0));
        meatLoversPizza.add(this.toppings.get(1));
        meatLoversPizza.add(this.toppings.get(2));
        meatLoversPizza.add(this.toppings.get(4));
        meatLoversPizza.add(this.toppings.get(11));
        this.add(new Pizza("Meat Lover's", meatLoversPizza));

        //creating Pizza object for Meat Lover's and adding it to PizzaList
        ArrayList<String> hawaiianPizza = new ArrayList<String>();
        hawaiianPizza.add(this.toppings.get(2));
        hawaiianPizza.add(this.toppings.get(3));
        this.add(new Pizza("Hawaiian", hawaiianPizza));

        //creating Pizza object for Meat Lover's and adding it to PizzaList
        ArrayList<String> motherlodePizza = new ArrayList<String>();
        motherlodePizza.add(this.toppings.get(0));
        motherlodePizza.add(this.toppings.get(1));
        motherlodePizza.add(this.toppings.get(2));
        motherlodePizza.add(this.toppings.get(3));
        motherlodePizza.add(this.toppings.get(4));
        motherlodePizza.add(this.toppings.get(5));
        motherlodePizza.add(this.toppings.get(6));
        motherlodePizza.add(this.toppings.get(7));
        motherlodePizza.add(this.toppings.get(8));
        motherlodePizza.add(this.toppings.get(9));
        motherlodePizza.add(this.toppings.get(10));
        motherlodePizza.add(this.toppings.get(11));
        motherlodePizza.add(this.toppings.get(12));
        motherlodePizza.add(this.toppings.get(13));
        this.add(new Pizza("The Motherlode", motherlodePizza));

        //creating Pizza object for Meat Lover's and adding it to PizzaList
        ArrayList<String> vegetarianPizza = new ArrayList<String>();
        vegetarianPizza.add(this.toppings.get(3));
        vegetarianPizza.add(this.toppings.get(5));
        vegetarianPizza.add(this.toppings.get(7));
        vegetarianPizza.add(this.toppings.get(8));
        vegetarianPizza.add(this.toppings.get(9));
        vegetarianPizza.add(this.toppings.get(10));
        vegetarianPizza.add(this.toppings.get(12));
        this.add(new Pizza("Vegetarian", vegetarianPizza));

        //creating Pizza object for Meat Lover's and adding it to PizzaList
        ArrayList<String> cheeseburgerPizza = new ArrayList<String>();
        cheeseburgerPizza.add(this.toppings.get(1));
        cheeseburgerPizza.add(this.toppings.get(4));
        cheeseburgerPizza.add(this.toppings.get(5));
        cheeseburgerPizza.add(this.toppings.get(10));
        cheeseburgerPizza .add(this.toppings.get(13));
        this.add(new Pizza("Cheeseburger", cheeseburgerPizza));
    }

    /**
     * This method is to be called inside of the constructor and
     * is used to fill the toppings ArrayList
     */
    private void fillToppings(){
        this.toppings = new ArrayList<>();
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
