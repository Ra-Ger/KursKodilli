package com.kodilla.good.patterns.challenges.Food2Door.producers;

import com.kodilla.good.patterns.challenges.Food2Door.Order;
import com.kodilla.good.patterns.challenges.Food2Door.OrderDTO;
import com.kodilla.good.patterns.challenges.Food2Door.Producer;
import com.kodilla.good.patterns.challenges.Food2Door.Product;

import java.util.ArrayList;
import java.util.List;

public class ExtraFoodShop extends Producer {
    public ExtraFoodShop()
    {
        companyName = "ExtraFoodShop";
        productList = new ArrayList<>(List.of(new Product("Potatoes", 6000),new Product("Onions",9000)));
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
