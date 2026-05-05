package com.kodilla.patterns2.decorator.pizza;

public class ExtraHotChilliDecorator extends AbstractPizzaDecorator {
    public ExtraHotChilliDecorator(Pizza pizza) {
        super(pizza);
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " extra hot chilli";
    }
    @Override
    public double getPrice() {
        return super.getPrice() + 4;
    }
}
