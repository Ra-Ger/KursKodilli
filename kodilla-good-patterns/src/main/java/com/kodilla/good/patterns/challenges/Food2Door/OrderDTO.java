package com.kodilla.good.patterns.challenges.Food2Door;

public class OrderDTO {
    String information;
    Order order;

    public OrderDTO(String information, Order order) {
        this.information = information;
        this.order = order;
    }

    public String getInformation() {
        return information;
    }

    public Order getOrder() {
        return order;
    }
}
