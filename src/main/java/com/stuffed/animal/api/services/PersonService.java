package com.stuffed.animal.api.services;

import com.stuffed.animal.api.designpatterns.factory.Person;

public interface PersonService {
    Person findById(Integer id);

    Person create(Person person);

    Person update(Person person);

    boolean delete(Integer customerId);

    Person findByEmail(String email);
}
