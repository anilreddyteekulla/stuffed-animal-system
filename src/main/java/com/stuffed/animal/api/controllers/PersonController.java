package com.stuffed.animal.api.controllers;

import com.stuffed.animal.api.designpatterns.factory.Person;
import com.stuffed.animal.api.designpatterns.factory.PersonFactory;
import com.stuffed.animal.api.dto.PersonDTO;
import com.stuffed.animal.api.models.PersonType;
import com.stuffed.animal.api.services.PersonService;
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
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/create/employee")
    public ResponseEntity<Person> createEmployee(@RequestBody PersonDTO person) {
        PersonFactory personFactory = new PersonFactory();
        Person employee = personFactory.createPerson(PersonType.EMPLOYEE, person.getFirstName(), person.getLastName(), person.getEmail());
        return new ResponseEntity<>(personService.create(employee), HttpStatus.OK);
    }

    @PostMapping("/create/customer")
    public ResponseEntity<Person> createCustomer(@RequestBody PersonDTO person) {
        PersonFactory personFactory = new PersonFactory();
        Person customer = personFactory.createPerson(PersonType.CUSTOMER, person.getFirstName(), person.getLastName(), person.getEmail());
        return new ResponseEntity<>(personService.create(customer), HttpStatus.OK);
    }

    @PostMapping("/create/admin")
    public ResponseEntity<Person> createAdmin(@RequestBody PersonDTO person) {
        PersonFactory personFactory = new PersonFactory();
        Person admin = personFactory.createPerson(PersonType.ADMIN, person.getFirstName(), person.getLastName(), person.getEmail());
        return new ResponseEntity<>(personService.create(admin), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(personService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Person> update(@RequestBody Person person) {
        Objects.requireNonNull(person.getId(), "Customer id cannot be null.");
        return new ResponseEntity<>(personService.update(person), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(personService.delete(id), HttpStatus.OK);
    }
}
