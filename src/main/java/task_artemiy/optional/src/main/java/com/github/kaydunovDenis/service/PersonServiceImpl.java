package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.exception.NullDataException;
import com.github.kaydunovDenis.model.Person;
import lombok.extern.log4j.Log4j;

import java.util.Objects;
import java.util.Optional;

@Log4j
public class PersonServiceImpl implements PersonService {
    @Override
    public void updatePerson(Person person, String firstName, String lastName, Integer age) {
        Optional.ofNullable(person).ifPresent(it -> {
            if (Objects.nonNull(firstName) && Objects.nonNull(lastName) && Objects.nonNull(age)) {
                it.setFirstName(firstName);
                it.setLastName(lastName);
                it.setAge(age);
                log.info(String.format("Data update: %s", person));
            } else throw new NullDataException("");
        });
    }
}
