package com.stuffed.animal.api.controllers;

import com.stuffed.animal.api.models.Customer;
import com.stuffed.animal.api.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> update(@RequestBody Customer customer) {
        Objects.requireNonNull(customer.getId(), "Customer id cannot be null.");
        return new ResponseEntity<>(customerService.updateCustomer(customer), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(customerService.deleteCustomer(id), HttpStatus.OK);
    }
}
