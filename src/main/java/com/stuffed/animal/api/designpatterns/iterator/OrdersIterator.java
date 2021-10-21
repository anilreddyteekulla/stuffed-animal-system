package com.stuffed.animal.api.designpatterns.iterator;

import com.stuffed.animal.api.models.Order;

import java.util.List;

public class OrdersIterator implements IIterator<Order> {
    List<Order> list;
    int index = 0;

    public OrdersIterator(List<Order> list) {
        this.list = list;
    }

    @Override
    public Order next() {
        Order order = list.get(index);
        index = index + 1;
        return order;
    }

    @Override
    public boolean hasNext() {
        return index < list.size() && list.get(index) != null;
    }
}

