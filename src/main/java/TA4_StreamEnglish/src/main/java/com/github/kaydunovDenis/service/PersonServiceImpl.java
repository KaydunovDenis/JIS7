package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.exception.NotFoundPersonException;
import com.github.kaydunovDenis.model.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PersonServiceImpl implements PersonService {
    public List<Person> findBestMatchingPersons(List<Person> list, String skillName, int proficiency) {
        return list.stream()
                .filter(person -> getProficiencyByNameSkill(person, skillName) > proficiency)
                .collect(Collectors.toList());
    }

    public Person findBestMatchingPerson(List<Person> list, String skillName) {
        return list.stream()
                .max(Comparator.comparingInt(person -> getProficiencyByNameSkill(person, skillName)))
                .orElseThrow(NotFoundPersonException::new);
    }

    public int getProficiencyByNameSkill(Person person, String skillName) {
        return Objects.requireNonNull(person.getSkills().stream()
                .filter(it -> Objects.equals(it.getName(), skillName))
                .findAny()
                .orElseThrow(NotFoundPersonException::new))
                .getProficiency();
    }
}
