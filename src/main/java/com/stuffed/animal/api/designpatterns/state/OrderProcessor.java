package com.stuffed.animal.api.designpatterns.state;

import com.stuffed.animal.api.models.Order;

public class OrderProcessor {
    OpenState openState;
    OrderedState orderedState;
    CancelledState cancelledState;
    ShippedState shippedState;
    DeliveredState deliveredState;
    OrderState state;
    Order order;

    public OrderProcessor(Order order) {
        this.order = order;
        openState = new OpenState(this);
        orderedState = new OrderedState(this);
        cancelledState = new CancelledState(this);
        shippedState = new ShippedState(this);
        deliveredState = new DeliveredState(this);
        this.state = openState;
    }

    public OrderState getState() {
        return this.state;
    }

    public void setState(OrderState orderState) {
        this.state = orderState;
    }

    public void confirmOrder() {
        state.confirmOrder();
    }

    public void shipOrder() {
        state.orderShipped();
    }

    public void deliverOrder() {
        state.orderDelivered();
    }

    public void cancelOrder() {
        state.cancel();
    }

    public OrderState getOrderedState() {
        return orderedState;
    }

    public OrderState getCanceledState() {

        return cancelledState;
    }

    public OrderState getShippedState() {
        return shippedState;
    }

    public OrderState getDeliveredState() {
        return deliveredState;
    }

}
