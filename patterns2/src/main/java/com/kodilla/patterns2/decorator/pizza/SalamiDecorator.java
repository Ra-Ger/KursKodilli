package com.kodilla.patterns2.decorator.pizza;

public class SalamiDecorator extends AbstractPizzaDecorator{
    private int stackCount;
    public final int maxCount = 5;
    public SalamiDecorator(Pizza pizza, int stackCount) {
        super(pizza);
        this.stackCount = stackCount;
    }

    public SalamiDecorator addStack() {
        stackCount = Math.min(stackCount + 1, maxCount);
        return this;
    }

    public int getStackCount() {
        return stackCount;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " salami x"  + stackCount;
    }

    @Override
    public double getPrice() {
        return super.getPrice() + (2*stackCount);
    }
}
