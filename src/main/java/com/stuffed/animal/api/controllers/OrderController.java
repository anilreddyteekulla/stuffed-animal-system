package com.stuffed.animal.api.controllers;

import com.stuffed.animal.api.models.Order;
import com.stuffed.animal.api.models.StuffedAnimal;
import com.stuffed.animal.api.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create/{customerId}")
    public ResponseEntity<Order> create(@PathVariable("customerId") Integer customerId, @RequestBody List<StuffedAnimal> stuffedAnimals) {
        return new ResponseEntity<>(orderService.placeOrder(customerId, stuffedAnimals), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Order> update(@RequestBody Order order) {
        Objects.requireNonNull(order.getId(), "Order id cannot be null.");
        return new ResponseEntity<>(orderService.update(order), HttpStatus.OK);
    }

    @GetMapping("/all/{customerId}")
    public ResponseEntity<List<Order>> findAll(@PathVariable("customerId") Integer customerId) {
        return new ResponseEntity<>(orderService.findAllOrders(customerId), HttpStatus.OK);
    }
}
