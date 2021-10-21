package com.stuffed.animal.api.designpatterns.factory;

import com.stuffed.animal.api.models.Order;
import com.stuffed.animal.api.models.PersonType;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

import java.util.List;

@KeySpace("persons")
public class Person {
    @Id
    private Integer id;

    private PersonType personType;

    private String firstName;

    private String lastName;

    private String email;

    private List<Order> orders;

    public Person(PersonType personType, String firstName, String lastName, String email, List<Order> orders) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.orders = orders;
        this.personType = personType;
    }

    public Person(PersonType personType, String firstName, String lastName, String email) {
        this(personType, firstName, lastName, email, null);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrders(List<Order> orders) {
        this.getOrders().addAll(orders);
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }
}
