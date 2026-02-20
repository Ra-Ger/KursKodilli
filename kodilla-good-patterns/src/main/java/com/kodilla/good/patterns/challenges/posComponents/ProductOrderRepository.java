package com.kodilla.good.patterns.challenges.posComponents;

public class ProductOrderRepository implements IOrderRepository{
    public void createOrder(User user, IProduct product) { System.out.println("Order saved."); }
}
