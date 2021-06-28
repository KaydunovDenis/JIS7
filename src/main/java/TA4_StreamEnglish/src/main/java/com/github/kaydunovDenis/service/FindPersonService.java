package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.model.Person;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public interface FindPersonService {
    static List<Person> findPersonsWithRequiredSkillAndProficiency(List<Person> list, String skillName, int proficiency) {
        return list.stream()
                .filter(person -> person.getProficiencyByNameSkill(skillName) > proficiency)
                .collect(Collectors.toList());
    }

    static Person findPersonWithBestProficiencyRequiredSkill(List<Person> list, String skillName) {
        return list.stream()
                .max(Comparator.comparingInt(person -> person.getProficiencyByNameSkill(skillName)))
                .orElseThrow();
    }
}
