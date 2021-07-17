package com.github.kaydunovDenis.repository;

import com.github.kaydunovDenis.model.Person;
import com.github.kaydunovDenis.model.Skill;

import java.util.List;

public class PersonRepository {
    private static List<Person> persons;

    public static void initialize() {
        persons = List.of(
                new Person(1L, "Look",
                        new Skill("English", 10),
                        new Skill("Kannada", 20),
                        new Skill("Hindi", 10)),
                new Person(2L, "Mahesh",
                        new Skill("English", 60),
                        new Skill("Kannada", 30),
                        new Skill("Hindi", 50)),
                new Person(3L, "Ganesh",
                        new Skill("English", 10),
                        new Skill("Kannada", 20),
                        new Skill("Hindi", 40)),
                new Person(4L, "Ramesh",
                        new Skill("English", 30),
                        new Skill("Kannada", 20),
                        new Skill("Hindi", 40)),
                new Person(5L, "Suresh",
                        new Skill("English", 70),
                        new Skill("Kannada", 40),
                        new Skill("Hindi", 40)),
                new Person(6L, "Ganesh",
                        new Skill("English", 100),
                        new Skill("Kannada", 20),
                        new Skill("Hindi", 40))
        );
    }

    public static List<Person> getPersons() {
        return persons;
    }
}
