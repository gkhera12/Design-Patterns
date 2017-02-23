package com.example.factorypattern;

/**
 * Created by gkhera on 26/04/16.
 */
public class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza(){
        name = "Chicago style Deep Dish Cheese Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded Mozzarella Cheese");
    }

    void cut(){
        System.out.println("Cutting the pizza into square slices");
    }
}
