package com.stuffed.animal.api.designpatterns.factory;

import com.stuffed.animal.api.models.PersonType;

public class CustomerPerson extends Person {

    public CustomerPerson(PersonType personType, String firstName, String lastName, String email) {
        super(personType, firstName, lastName, email);
    }
}
