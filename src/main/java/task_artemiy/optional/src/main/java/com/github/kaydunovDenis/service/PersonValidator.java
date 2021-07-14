package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.exception.NullDataException;
import com.github.kaydunovDenis.model.Person;
import org.jetbrains.annotations.Contract;

public class PersonValidator {
    @Contract("null, 0 -> fail")
    public static boolean validateEmptyValue(Person person) {
        if (person == null ||
                person.getFirstName() == null ||
                person.getLastName() == null ||
                person.getAge() == null ||
                person.getAge() == 0)
            throw new NullDataException("First name, last name should not be null and Age greater than zero");
        return true;
    }
}
