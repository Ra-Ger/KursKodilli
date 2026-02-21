package com.kodilla.good.patterns.challenges.Food2Door;

import com.kodilla.good.patterns.challenges.Food2Door.producers.ExtraFoodShop;
import com.kodilla.good.patterns.challenges.Food2Door.producers.HumanMeatMarket;
import com.kodilla.good.patterns.challenges.posComponents.*;

import java.util.Map;

public class Food2DoorExecutor {
    public static void main(String[] args) {
        Order order1 = new Order(Map.of("Onions", 100),"01234DE");
        Order order2 = new Order(Map.of("Fingers",100, "Potatoes",1000000, "Onions", 100),"00030XE");
        Producer producer = new ExtraFoodShop();
        System.out.println(producer.process(order1).information);
        producer = new HumanMeatMarket();
        System.out.println(producer.process(order2).information);
    }
}
