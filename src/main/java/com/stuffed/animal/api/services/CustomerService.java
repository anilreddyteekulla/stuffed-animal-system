package com.stuffed.animal.api.services;

import com.stuffed.animal.api.models.Customer;

public interface CustomerService {
    Customer findById(Integer id);

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    boolean deleteCustomer(Integer customerId);

    Customer findByEmail(String email);
}
