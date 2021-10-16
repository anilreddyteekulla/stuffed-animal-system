package com.stuffed.animal.api.services.impl;

import com.stuffed.animal.api.designpatterns.iterator.IIterator;
import com.stuffed.animal.api.designpatterns.iterator.StuffedAnimalIterator;
import com.stuffed.animal.api.exceptions.NoCustomerFoundException;
import com.stuffed.animal.api.models.Customer;
import com.stuffed.animal.api.models.Order;
import com.stuffed.animal.api.models.StuffedAnimal;
import com.stuffed.animal.api.repositories.CustomerRepository;
import com.stuffed.animal.api.repositories.LineItemRepository;
import com.stuffed.animal.api.repositories.OrderRepository;
import com.stuffed.animal.api.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private LineItemRepository lineItemRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Order placeOrder(Integer customerId, List<StuffedAnimal> stuffedAnimals) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            Order order = new Order();
            order.setCustomerId(customerId);
            order.setCreatedDate(new Date());
            order.setStuffedAnimals(stuffedAnimals);

            // calculate the total cost using iterator design pattern
            BigDecimal totalCost = BigDecimal.ZERO;
            IIterator iterator = createStuffedAnimalIterator(stuffedAnimals);
            while (iterator.hasNext()) {
                StuffedAnimal stuffedAnimal = iterator.next();
                totalCost = totalCost.add(stuffedAnimal.getPrice());
            }
            order.setTotalPrice(totalCost);

            return order;

        } else {
            throw new NoCustomerFoundException("No customer found.");
        }

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

    public IIterator createStuffedAnimalIterator(List<StuffedAnimal> list) {
        return new StuffedAnimalIterator(list);
    }
}
