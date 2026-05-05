package com.kodilla.patterns2.decorator.pizza;

public class PizzaDecoratorManager {

    public static Pizza applyExtraHotChilli(Pizza pizza) {
        if(pizza.hasDecorator(ExtraHotChilliDecorator.class)){
            {
                System.out.println("Hot chilli already added.");
                return pizza;
            }
        }
        return new ExtraHotChilliDecorator(pizza);
    }

    public static Pizza applySalami(Pizza pizza) {
        if(pizza.hasDecorator(SalamiDecorator.class)){
            if((((SalamiDecorator) pizza).getStackCount() == ((SalamiDecorator)pizza).maxCount )) {
                System.out.println("Cannot add more.");
            }
            return ((SalamiDecorator) pizza).addStack();
        }
        return new SalamiDecorator(pizza,1);
    }

    public static Pizza applyCheese(Pizza pizza) {
        if(pizza.hasDecorator(CheeseDecorator.class)) {
            if (((CheeseDecorator) pizza).getStackCount() == ((CheeseDecorator) pizza).maxCount) {
                System.out.println("Cannot add more.");
            }
            return ((CheeseDecorator) pizza).addStack();
        }
        return new CheeseDecorator(pizza,1);
    }
}
