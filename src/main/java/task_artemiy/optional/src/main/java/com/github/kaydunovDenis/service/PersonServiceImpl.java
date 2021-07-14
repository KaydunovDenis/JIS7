package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.exception.NullDataException;
import com.github.kaydunovDenis.model.Person;
import lombok.extern.log4j.Log4j;

import java.util.Optional;

@Log4j
public class PersonServiceImpl implements PersonService {
    @Override
    public Person updatePerson(Person person, String firstName, String lastName, Integer age) {
        Person testPerson = new Person(firstName, lastName, age);
        if (PersonValidator.validate(testPerson)) {
            Optional.ofNullable(person).ifPresent(it -> {
                it.setFirstName(firstName);
                it.setLastName(lastName);
                it.setAge(age);
            });
            log.info(String.format("Data update: %s", person));
            return person;
        } else throw new NullDataException("Data for update invalid. Data must be not null.");
    }
}
