package com.kodilla;

import com.kodilla.good.patterns.challenges.MovieStore;
import com.kodilla.good.patterns.challenges.ProductOrderService;
import com.kodilla.good.patterns.challenges.posComponents.*;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        BuyRequest buyRequest = new BuyRequest(new User("Adolf", 782029252), new Uran());

        ProductOrderService productOrderService = new ProductOrderService(
                new SMS(),
                new ProductOrderServiceTemplate(),
                new ProductOrderRepository()
        );

        productOrderService.process(buyRequest);
    }
}

