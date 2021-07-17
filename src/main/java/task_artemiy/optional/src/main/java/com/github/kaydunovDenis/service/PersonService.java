package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.model.Person;

public interface PersonService {
    Person updatePerson(Person person, String firstName, String secondName, Integer age);
}
