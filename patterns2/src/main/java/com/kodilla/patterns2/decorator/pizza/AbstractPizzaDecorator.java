package com.kodilla.patterns2.decorator.pizza;

public abstract class AbstractPizzaDecorator implements Pizza{
    private final Pizza pizza;
    public AbstractPizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double getPrice() {
        return pizza.getPrice();
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public boolean hasDecorator(Class<? extends AbstractPizzaDecorator> decoratorClass) {
        if (decoratorClass.isInstance(this)) {
            return true;
        }
        return pizza.hasDecorator(decoratorClass);
    }

}
