package com.kodilla.good.patterns.challenges.Food2Door;

import com.kodilla.good.patterns.challenges.Food2Door.producers.ExtraFoodShop;
import com.kodilla.good.patterns.challenges.Food2Door.producers.HumanMeatMarket;
import com.kodilla.good.patterns.challenges.ProductOrderService;
import com.kodilla.good.patterns.challenges.posComponents.*;

import java.util.ArrayList;
import java.util.List;

public class Food2DoorExecutor {
    public static void main(String[] args) {
        Order order1 = new Order(new ArrayList<>(List.of(new Product("Onions", 100))),"01234DE");
        Order order2 = new Order(new ArrayList<>(List.of(new Product("Fingers",100), new Product("Potatoes",1000000),new Product("Onions", 100))),"00030XE");
        Producer producer = new ExtraFoodShop();
        System.out.println(producer.process(order1).information);
        producer = new HumanMeatMarket();
        System.out.println(producer.process(order2).information);
    }
}
