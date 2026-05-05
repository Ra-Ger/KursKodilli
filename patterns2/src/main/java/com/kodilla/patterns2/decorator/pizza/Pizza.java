package com.kodilla.patterns2.decorator.pizza;

public interface Pizza {
    double getPrice();
    String getDescription();
    boolean hasDecorator(Class<? extends AbstractPizzaDecorator> decoratorClass);
}
