package com.kodilla.good.patterns.challenges.posComponents;

public class PurchaseDTO {
    IProduct product;
    User user;
    boolean wasOrdered;

    public PurchaseDTO(IProduct product, User user, boolean wasOrdered) {
        this.product = product;
        this.user = user;
        this.wasOrdered = wasOrdered;
    }
}
