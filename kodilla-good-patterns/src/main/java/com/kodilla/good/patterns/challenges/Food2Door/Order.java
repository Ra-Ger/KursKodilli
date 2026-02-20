package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
    List<Product> productOrderList;
    String orderID;

    public Order(List<Product> productOrderList, String orderID) {
        this.productOrderList = productOrderList;
        this.orderID = orderID;
    }

    public List<Product> getProductOrderList() {
        return new ArrayList<>(productOrderList);
    }

    public String getOrderID() {
        return orderID;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(productOrderList, order.productOrderList) && Objects.equals(orderID, order.orderID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productOrderList, orderID);
    }
}
