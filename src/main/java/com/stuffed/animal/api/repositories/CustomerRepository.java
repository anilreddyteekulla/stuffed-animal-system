package com.stuffed.animal.api.repositories;

import com.stuffed.animal.api.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer findByEmail(String email);
}
