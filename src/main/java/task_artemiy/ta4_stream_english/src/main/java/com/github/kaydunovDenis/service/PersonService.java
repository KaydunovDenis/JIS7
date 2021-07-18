package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.model.Person;

import java.util.Collection;
import java.util.List;

public interface PersonService {
    Collection<Person> findBestMatchingPersons(List<Person> list, String skillName, int proficiency);

    Person findBestMatchingPerson(List<Person> list, String skillName);

    int getProficiencyByNameSkill(Person person, String skillName);
}
