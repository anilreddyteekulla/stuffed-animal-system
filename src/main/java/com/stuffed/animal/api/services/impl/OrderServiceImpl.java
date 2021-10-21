package com.stuffed.animal.api.services.impl;

import com.stuffed.animal.api.designpatterns.factory.Person;
import com.stuffed.animal.api.designpatterns.iterator.IIterator;
import com.stuffed.animal.api.designpatterns.iterator.StuffedAnimalIterator;
import com.stuffed.animal.api.designpatterns.state.OrderProcessor;
import com.stuffed.animal.api.exceptions.NoPersonFoundException;
import com.stuffed.animal.api.models.Order;
import com.stuffed.animal.api.models.StuffedAnimal;
import com.stuffed.animal.api.repositories.LineItemRepository;
import com.stuffed.animal.api.repositories.OrderRepository;
import com.stuffed.animal.api.repositories.PersonRepository;
import com.stuffed.animal.api.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private LineItemRepository lineItemRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Order placeOrder(Integer customerId, List<StuffedAnimal> stuffedAnimals) {
        Optional<Person> customerOptional = personRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            Order order = new Order();
            order.setCustomerId(customerId);
            order.setCreatedDate(new Date());
            order.setStuffedAnimals(stuffedAnimals);

            // calculate the total cost using iterator design pattern
            BigDecimal totalCost = BigDecimal.ZERO;
            IIterator<StuffedAnimal> iterator = createStuffedAnimalIterator(stuffedAnimals);
            while (iterator.hasNext()) {
                StuffedAnimal stuffedAnimal = iterator.next();
                totalCost = totalCost.add(stuffedAnimal.getPrice());
            }
            order.setTotalPrice(totalCost);
            orderRepository.save(order);

            // process order using state design pattern
            CompletableFuture.runAsync(() -> processOrder(order));

            return order;

        } else {
            throw new NoPersonFoundException("No customer found.");
        }

    }

    private void processOrder(Order order) {
        Executor delayed = CompletableFuture.delayedExecutor(5L, TimeUnit.SECONDS);
        CompletableFuture.supplyAsync(() -> {
                    final OrderProcessor orderProcessor = new OrderProcessor(order);
                    // confirm order
                    orderProcessor.confirmOrder();
                    order.setOrderState(orderProcessor.getState());
                    orderRepository.save(order);
                    // simulating time for order confirmation
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // ship the confirmed order
                    orderProcessor.shipOrder();
                    order.setOrderState(orderProcessor.getState());
                    orderRepository.save(order);
                    // simulating order shipping time
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // deliver the shipped order
                    orderProcessor.deliverOrder();
                    order.setOrderState(orderProcessor.getState());
                    orderRepository.save(order);
                    // simulating order delivery time
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return orderProcessor;
                }, delayed)
                .join();
    }

    @Override
    public List<Order> findAllOrders(Integer customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderRepository.findById(id).orElse(null);

    }

    @Override
    public Order update(Order order) {
        return orderRepository.findById(order.getId()).map(order1 -> {
            order1.setStuffedAnimals(order.getStuffedAnimals());
            order1.setTotalPrice(order.getTotalPrice());
            order1.setCreatedDate(order.getCreatedDate());
            order1.setCustomerId(order.getCustomerId());
            return order1;
        }).map(orderRepository::save).orElse(null);

    }

    public IIterator<StuffedAnimal> createStuffedAnimalIterator(List<StuffedAnimal> list) {
        return new StuffedAnimalIterator(list);
    }
}
