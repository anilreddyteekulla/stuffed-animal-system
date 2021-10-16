package com.stuffed.animal.api.repositories;

import com.stuffed.animal.api.models.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
    List<Order> findByCustomerId(Integer customerId);
}
