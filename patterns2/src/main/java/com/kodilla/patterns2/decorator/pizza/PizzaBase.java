package com.kodilla.patterns2.decorator.pizza;

public class PizzaBase implements Pizza{
    @Override
    public double getPrice() {
        return 15;
    }
    @Override
    public String getDescription() {
        return "Pizza with: ";
    }

    @Override
    public boolean hasDecorator(Class<? extends AbstractPizzaDecorator> decoratorClass) {
        return false;
    }
}
