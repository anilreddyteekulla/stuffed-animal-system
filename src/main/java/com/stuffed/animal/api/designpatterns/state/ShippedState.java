package com.stuffed.animal.api.designpatterns.state;

import com.stuffed.animal.api.models.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShippedState implements OrderState {
    Logger log = LoggerFactory.getLogger(ShippedState.class);
    OrderProcessor orderProcessor;

    public ShippedState(OrderProcessor orderProcessor) {
        this.orderProcessor = orderProcessor;
    }

    @Override
    public void confirmOrder() {
        log.error("Can not confirm an order when it is in shipped state.");
    }

    @Override
    public void cancel() {
        log.error("Can not cancelled an order when it is in shipped state.");
    }

    @Override
    public void orderShipped() {
        log.error("Can not ship an order when it is in shipped state.");
    }

    @Override
    public void orderDelivered() {
        Order order = orderProcessor.order;
        log.info("The order with {} has been delivered successfully to customer with customerId: {}.", order.getId(), order.getCustomerId());
        orderProcessor.setState(orderProcessor.getDeliveredState());
    }

}