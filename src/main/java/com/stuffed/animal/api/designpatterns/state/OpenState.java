package com.stuffed.animal.api.designpatterns.state;

import com.stuffed.animal.api.models.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenState implements OrderState {
    Logger log = LoggerFactory.getLogger(OpenState.class);
    OrderProcessor orderProcessor;

    public OpenState(OrderProcessor orderProcessor) {
        this.orderProcessor = orderProcessor;
    }

    @Override
    public void confirmOrder() {
        Order order = orderProcessor.order;
        log.info("The order with {} has been confirmed for customer with customerId: {}.", order.getId(), order.getCustomerId());
        orderProcessor.setState(orderProcessor.getOrderedState());
    }

    @Override
    public void cancel() {
        log.info("The order has been cancelled.");
        orderProcessor.setState(orderProcessor.getCanceledState());

    }

    @Override
    public void orderShipped() {
        log.error("Order cannot be shipped.");
    }

    @Override
    public void orderDelivered() {
        log.error("Order cannot be delivered.");
    }

}