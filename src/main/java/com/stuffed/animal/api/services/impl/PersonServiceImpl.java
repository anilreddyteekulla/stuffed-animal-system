package com.stuffed.animal.api.services.impl;

import com.stuffed.animal.api.designpatterns.factory.Person;
import com.stuffed.animal.api.exceptions.NoPersonFoundException;
import com.stuffed.animal.api.repositories.PersonRepository;
import com.stuffed.animal.api.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person findById(Integer id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if (personOptional.isPresent()) {
            return personOptional.get();
        } else {
            throw new NoPersonFoundException("No person found with id " + id);
        }
    }

    @Override
    public Person create(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person update(Person person) {
        Optional<Person> existingCustomerOptional = personRepository.findById(person.getId());
        if (existingCustomerOptional.isPresent()) {
            Person cust = existingCustomerOptional.get();
            cust.setFirstName(person.getFirstName());
            cust.setLastName(person.getLastName());
            cust.setEmail(person.getEmail());
            cust.setEmail(person.getEmail());
            cust.addOrders(cust.getOrders());
            return personRepository.save(cust);
        } else {
            throw new NoPersonFoundException("No person found with id " + person.getId());
        }
    }

    @Override
    public boolean delete(Integer personId) {
        personRepository.deleteById(personId);
        return true;
    }

    @Override
    public Person findByEmail(String email) {
        return personRepository.findByEmail(email);
    }
}
