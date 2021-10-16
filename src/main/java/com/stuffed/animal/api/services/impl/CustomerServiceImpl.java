package com.stuffed.animal.api.services.impl;

import com.stuffed.animal.api.exceptions.NoCustomerFoundException;
import com.stuffed.animal.api.models.Customer;
import com.stuffed.animal.api.repositories.CustomerRepository;
import com.stuffed.animal.api.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer findById(Integer id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            return customerOptional.get();
        } else {
            throw new NoCustomerFoundException("No customer found with id " + id);
        }
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Optional<Customer> existingCustomerOptional = customerRepository.findById(customer.getId());
        if (existingCustomerOptional.isPresent()) {
            Customer cust = existingCustomerOptional.get();
            cust.setFirstName(customer.getFirstName());
            cust.setLastName(customer.getLastName());
            cust.setEmail(customer.getEmail());
            cust.setEmail(customer.getEmail());
            cust.addOrders(cust.getOrders());
            return customerRepository.save(cust);
        } else {
            throw new NoCustomerFoundException("No customer found with id " + customer.getId());
        }
    }

    @Override
    public boolean deleteCustomer(Integer customerId) {
        customerRepository.deleteById(customerId);
        return true;
    }

    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}
