package com.stuffed.animal.api.repositories;

import com.stuffed.animal.api.designpatterns.factory.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
    Person findByEmail(String email);
}
