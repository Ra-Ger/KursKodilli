package com.kodilla.good.patterns.challenges.Food2Door.producers;

import com.kodilla.good.patterns.challenges.Food2Door.Order;
import com.kodilla.good.patterns.challenges.Food2Door.OrderDTO;
import com.kodilla.good.patterns.challenges.Food2Door.Producer;
import com.kodilla.good.patterns.challenges.Food2Door.Product;

import java.util.HashMap;
import java.util.Map;

public class HumanMeatMarket extends Producer {
    public HumanMeatMarket()
    {
        companyName = "HumanMeatMarket";
        productStock  = new HashMap<>(Map.of("Fingers", 3000,"Legs",900));
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
