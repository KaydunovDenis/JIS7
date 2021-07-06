package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.model.Person;

import java.util.Objects;
import java.util.Optional;

public class PersonServiceImpl implements PersonService {

    @Override
    public void updatePerson(Person person, String firstName, String lastName, Integer age) {
        Optional.ofNullable(person).ifPresent(it -> {
            if (Objects.nonNull(firstName) && Objects.nonNull(lastName) && Objects.nonNull(age)) {
                it.setFirstName(firstName);
                it.setLastName(lastName);
                it.setAge(age);
            }
        });
    }
}
