package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.model.Person;

public class PersonValidator {
    public static boolean validate(Person person) {
        return person != null &&
                person.getFirstName() != null &&
                person.getLastName() != null &&
                person.getAge() != null &&
                person.getAge() != 0;
    }
}
