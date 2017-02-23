package com.example.factorypattern;

/**
 * Created by gkhera on 26/04/16.
 */
public class ChicagoPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        switch (type){
            case "cheese":
                return new ChicagoStyleCheesePizza();
            case "veggie":
                return null;
            case "clam":
                return null;
            case "pepperoni":
                return null;
            default:
                return null;
        }
    }
}
