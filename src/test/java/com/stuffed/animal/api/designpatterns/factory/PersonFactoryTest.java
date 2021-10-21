package com.stuffed.animal.api.designpatterns.factory;

import com.stuffed.animal.api.models.PersonType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonFactoryTest {
    @Test
    public void testCreatePersonMethodWithCustomerTypeReturnCustomerPersonObject() {
        // given
        PersonType personType = PersonType.CUSTOMER;
        String firstName = "John";
        String lastName = "Doe";
        String email = "test@email.com";
        PersonFactory personFactory = new PersonFactory();

        // when
        Person person = personFactory.createPerson(personType, firstName, lastName, email);

        // then
        assertTrue(person instanceof CustomerPerson);
    }

    @Test
    public void testCreatePersonMethodWithEmployeeTypeReturnEmployeePersonObject() {
        // given
        PersonType personType = PersonType.EMPLOYEE;
        String firstName = "John";
        String lastName = "Doe";
        String email = "test@email.com";
        PersonFactory personFactory = new PersonFactory();

        // when
        Person person = personFactory.createPerson(personType, firstName, lastName, email);

        // then
        assertTrue(person instanceof EmployeePerson);
    }

    @Test
    public void testCreatePersonMethodWithAdminTypeReturnAdminPersonObject() {
        // given
        PersonType personType = PersonType.ADMIN;
        String firstName = "John";
        String lastName = "Doe";
        String email = "test@email.com";
        PersonFactory personFactory = new PersonFactory();

        // when
        Person person = personFactory.createPerson(personType, firstName, lastName, email);

        // then
        assertTrue(person instanceof AdminPerson);
    }
}
