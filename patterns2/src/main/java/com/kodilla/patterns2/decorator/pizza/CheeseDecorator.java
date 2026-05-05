package com.kodilla.patterns2.decorator.pizza;

public class CheeseDecorator extends AbstractPizzaDecorator{

    private int stackCount;
    public final int maxCount = 3;
    public CheeseDecorator(Pizza pizza, int stackCount) {
        super(pizza);
        this.stackCount = stackCount;
    }

    public CheeseDecorator addStack(){
        stackCount = Math.min(stackCount + 1, maxCount);
        return this;
    }

    public int getStackCount() {
        return stackCount;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " cheese x"  + stackCount;
    }

    @Override
    public double getPrice() {
        return super.getPrice() + (3.5*stackCount);
    }

}
