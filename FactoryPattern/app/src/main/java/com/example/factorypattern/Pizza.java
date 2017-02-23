package com.example.factorypattern;

import java.util.ArrayList;

/**
 * Created by gkhera on 26/04/16.
 */
public abstract class Pizza {
    String name;
    String dough;
    String sauce;
    ArrayList toppings = new ArrayList();

    void prepare(){
        System.out.println("Preparing "+name);
        System.out.println("Tossing Dough.. ");
        System.out.println("Adding sauce.. ");
        System.out.println("Adding toppings: ");
        for(int i=0; i<toppings.size(); i++){
            System.out.println(" "+toppings.get(i));
        }
    }

    void bake(){
        System.out.println("Bake for 25 min at 350");
    }

    void cut(){
        System.out.println("Cutting pizza into diagonal slices");
    }

    void box(){
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName(){
        return name;
    }
}
