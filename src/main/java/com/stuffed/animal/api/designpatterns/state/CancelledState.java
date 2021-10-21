package com.stuffed.animal.api.designpatterns.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CancelledState implements OrderState {
    Logger log = LoggerFactory.getLogger(CancelledState.class);
    OrderProcessor orderProcessor;

    public CancelledState(OrderProcessor orderProcessor) {
        this.orderProcessor = orderProcessor;
    }

    @Override
    public void confirmOrder() {
        log.error("Can not confirm an order when it is in cancelled state.");
    }

    @Override
    public void cancel() {
        log.error("The order has been cancelled.");
        orderProcessor.setState(orderProcessor.getCanceledState());
    }

    @Override
    public void orderShipped() {
        log.error("Can not ship an order when it is in cancelled state.");
    }

    @Override
    public void orderDelivered() {
        log.error("Can not deliver an order when it is in cancelled state.");
    }

}