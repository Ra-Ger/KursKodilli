package com.kodilla.good.patterns.challenges.posComponents;

public class BuyRequest {
    User user;
    IProduct product;

    public BuyRequest(User user, IProduct product) {
        this.user = user;
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public IProduct getProduct() {
        return product;
    }
}
