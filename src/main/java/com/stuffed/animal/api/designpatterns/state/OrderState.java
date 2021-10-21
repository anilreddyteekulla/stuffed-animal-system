package com.stuffed.animal.api.designpatterns.state;

public interface OrderState {
    void confirmOrder();

    void cancel();

    void orderShipped();

    void orderDelivered();
}
