package com.stuffed.animal.api.repositories;

import com.stuffed.animal.api.models.StuffedAnimal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StuffedAnimalRepository extends CrudRepository<StuffedAnimal, Integer> {
}