package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.exception.NotFoundPersonException;
import com.github.kaydunovDenis.model.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j(topic = "PersonServiceImpl")
public class PersonServiceImpl implements PersonService {
    public Collection<Person> findBestMatchingPersons(List<Person> list, String skillName, int proficiency) {
        log.info("Find best matching from persons: {} - {}.", skillName, proficiency);
        Collection<Person> persons =  list.stream()
                .filter(person -> getProficiencyByNameSkill(person, skillName) > proficiency)
                .collect(Collectors.toList());
        persons.forEach(it->log.info(it.toString()));
        return persons;
    }

    public Person findBestMatchingPerson(List<Person> list, String skillName) {
        log.info("Find best matching person: " + skillName);
        Person resultPerson = list.stream()
                .max(Comparator.comparingInt(person -> getProficiencyByNameSkill(person, skillName)))
                .orElseThrow(NotFoundPersonException::new);
        log.info(resultPerson.toString());
        return resultPerson;
    }

    public int getProficiencyByNameSkill(Person person, String skillName) {
        return person.getSkills().stream()
                .filter(it -> Objects.equals(it.getName(), skillName))
                .findAny()
                .orElseThrow(NotFoundPersonException::new)
                .getProficiency();
    }
}
