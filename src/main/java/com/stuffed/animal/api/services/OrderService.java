package com.stuffed.animal.api.services;

import com.stuffed.animal.api.models.Order;
import com.stuffed.animal.api.models.StuffedAnimal;

import java.util.List;

public interface OrderService {
    Order placeOrder(Integer customerId, List<StuffedAnimal> stuffedAnimals);

    List<Order> findAllOrders(Integer customerId);

    Order getOrderById(Integer id);

    Order update(Order order);
}
