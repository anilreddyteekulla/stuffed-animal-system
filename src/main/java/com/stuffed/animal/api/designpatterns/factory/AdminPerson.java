package com.stuffed.animal.api.designpatterns.factory;

import com.stuffed.animal.api.models.PersonType;

public class AdminPerson extends Person {

    public AdminPerson(PersonType personType, String firstName, String lastName, String email) {
        super(personType, firstName, lastName, email);
    }
}
