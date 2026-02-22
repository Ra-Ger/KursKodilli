package com.kodilla.good.patterns.challenges.Food2Door.producers;

import com.kodilla.good.patterns.challenges.Food2Door.Order;
import com.kodilla.good.patterns.challenges.Food2Door.OrderDTO;
import com.kodilla.good.patterns.challenges.Food2Door.Producer;

import java.util.HashMap;
import java.util.Map;

public class ExtraFoodShop extends Producer {
    public ExtraFoodShop()
    {
        companyName = "ExtraFoodShop";
        productStock  = new HashMap<>(Map.of("Potatoes", 6000,"Onions",9000));
    }

    @Override
    public OrderDTO process(Order order) {
        if(!checkIfOrderIsPossible(order))
        {
            return new OrderDTO("Ordered products not available!",order);
        }
        else return new OrderDTO("Order: " + order.getOrderID() + " was successfully registered.",order);

    }
}
