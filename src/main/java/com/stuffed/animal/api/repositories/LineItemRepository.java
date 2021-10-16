package com.stuffed.animal.api.repositories;

import com.stuffed.animal.api.models.LineItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineItemRepository extends CrudRepository<LineItem, Integer> {
}
