package com.stuffed.animal.api.designpatterns.state;

import com.stuffed.animal.api.models.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderedState implements OrderState {
    Logger log = LoggerFactory.getLogger(OrderedState.class);
    OrderProcessor orderProcessor;

    public OrderedState(OrderProcessor orderProcessor) {
        this.orderProcessor = orderProcessor;
    }

    @Override
    public void confirmOrder() {
        log.error("Can not confirm an order when it is in the ordered state");
    }

    @Override
    public void cancel() {
        log.error("The order has been cancelled.");
        orderProcessor.setState(orderProcessor.getCanceledState());
    }

    @Override
    public void orderShipped() {
        Order order = orderProcessor.order;
        log.info("The order with {} has been shipped for customer with customerId: {}.", order.getId(), order.getCustomerId());
        orderProcessor.setState(orderProcessor.getShippedState());
    }

    @Override
    public void orderDelivered() {
        log.info("Can not deliver an order when it is in ordered state.");
    }

}