package com.stuffed.animal.api.designpatterns.factory;

import com.stuffed.animal.api.models.PersonType;

public class PersonFactory {
    public Person createPerson(PersonType personType, String firstName, String lastName, String email) {
        switch (personType) {
            case ADMIN:
                return new AdminPerson(personType, firstName, lastName, email);
            case CUSTOMER:
                return new CustomerPerson(personType, firstName, lastName, email);
            case EMPLOYEE:
                return new EmployeePerson(personType, firstName, lastName, email);
            default:
                throw new IllegalArgumentException("No such type person exists");
        }
    }
}
