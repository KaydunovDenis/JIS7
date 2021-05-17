package com.github.kaydunovDenis;

import com.github.kaydunovDenis.model.Person;
import com.github.kaydunovDenis.model.Skill;

import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1L, "Look", new Skill("English", 10),
                new Skill("Kannada", 20), new Skill("Hindi", 10)));
        persons.add(new Person(2L, "Mahesh", new Skill("English", 10),
                new Skill("Kannada", 30), new Skill("Hindi", 50)));
        persons.add(new Person(3L, "Ganesh", new Skill("English", 10),
                new Skill("Kannada", 20), new Skill("Hindi", 40)));
        persons.add(new Person(4L, "Ramesh", new Skill("English", 10),
                new Skill("Kannada", 20), new Skill("Hindi", 40)));
        persons.add(new Person(5L, "Suresh", new Skill("English", 10),
                new Skill("Kannada", 40), new Skill("Hindi", 40)));
        persons.add(new Person(6L, "Ganesh", new Skill("English", 100),
                new Skill("Kannada", 20), new Skill("Hindi", 40)));

        persons.forEach(System.out::println);

        System.out.println("Person has English > 50%");
        findPersonHasNeedSkill(persons, "English").forEach(System.out::println);

        System.out.println("Person has Kannada > 50%");
        findPersonHasNeedSkill(persons, "Kannada").forEach(System.out::println);


    }

    private static ArrayList<Person> findPersonHasNeedSkill(List<Person> persons, String language) {
        var personList = (ArrayList<Person>) persons.stream()
                .filter(person -> person.getSkills().stream()
                        .anyMatch(skill -> skill.getName().equals(language) && skill.getProficiency() > 50))
                .collect(Collectors.toList());
        if (personList.size() <= 0) {
            personList.add(persons.stream()
                    .max(Comparator.comparingInt(person -> person.getSkills().stream()
                            .filter(skill -> skill.getName().equals(language))
                            .findFirst().map(Skill::getProficiency)
                            .orElse(0)))
                    .orElse(null));
        }
        return personList;
    }
}



