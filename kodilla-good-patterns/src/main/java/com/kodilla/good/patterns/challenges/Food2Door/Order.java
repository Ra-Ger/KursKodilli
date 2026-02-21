package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Order {
    Map<String,Integer> productStock;
    String orderID;

    public Order(Map<String,Integer> productOrderList, String orderID) {
        this.productStock = productOrderList;
        this.orderID = orderID;
    }

    public  Map<String,Integer> getProductStock() {
        return new HashMap<>(productStock);
    }

    public String getOrderID() {
        return orderID;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(productStock, order.productStock) && Objects.equals(orderID, order.orderID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productStock, orderID);
    }
}
