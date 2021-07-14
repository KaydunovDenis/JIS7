package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.exception.NullDataException;
import com.github.kaydunovDenis.model.Person;

public class PersonValidator {
    public static boolean validateEmptyValue(Person person) {
        if (person == null || person.getAge() == 0)
            throw new NullDataException("First name, last name should not be null and Age greater than zero");
        return true;
    }
}
