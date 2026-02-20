package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.Objects;

public class Product {

    protected String kindOfProduct;
    protected int availableAmount;

    public Product(String kindOfProduct, int availableAmount)
    {
        this.kindOfProduct = kindOfProduct;
        this.availableAmount = availableAmount;
    }

    public String getKindOfProduct() {
        return kindOfProduct;
    }

    public int getAvailableAmount() {
        return availableAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return availableAmount == product.availableAmount && Objects.equals(kindOfProduct, product.kindOfProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kindOfProduct, availableAmount);
    }
}
