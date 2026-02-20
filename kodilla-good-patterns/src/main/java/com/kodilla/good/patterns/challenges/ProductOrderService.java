package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.posComponents.*;

public class ProductOrderService {
    private final IInformationService informationService;
    private final IOrderService orderService;
    private final IOrderRepository orderRepository;

    public ProductOrderService(IInformationService informationService,
                               IOrderService orderService,
                               IOrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public PurchaseDTO process(final BuyRequest buyRequest) {
        boolean isOrdered = orderService.order(buyRequest.getUser(), buyRequest.getProduct());
        if (isOrdered) {
            informationService.sendMessage(buyRequest.getUser());
            orderRepository.createOrder(buyRequest.getUser(), buyRequest.getProduct());
            return new PurchaseDTO(buyRequest.getProduct(), buyRequest.getUser(), true);
        } else {
            return new PurchaseDTO(buyRequest.getProduct(), buyRequest.getUser(), false);
        }
    }
}
