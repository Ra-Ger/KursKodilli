package com.kodilla.good.patterns.challenges.Food2Door.producers;

import com.kodilla.good.patterns.challenges.Food2Door.Order;
import com.kodilla.good.patterns.challenges.Food2Door.OrderDTO;
import com.kodilla.good.patterns.challenges.Food2Door.Producer;
import com.kodilla.good.patterns.challenges.Food2Door.Product;

import java.util.ArrayList;
import java.util.List;

public class HumanMeatMarket extends Producer {
    public HumanMeatMarket()
    {
        companyName = "HumanMeatMarket";
        productList = new ArrayList<>(List.of(new Product("Fingers", 3000),new Product("Legs",900)));
    }

    @Override
    public OrderDTO process(Order order) {
        if(!checkIfOrderIsPossible(order))
        {
            return new OrderDTO("Sorry. Order denied",order);
        }
        else return new OrderDTO("Order: " + order.getOrderID() + " was successfully registered.",order);

    }
}
