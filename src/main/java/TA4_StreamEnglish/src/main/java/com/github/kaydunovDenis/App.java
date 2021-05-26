package com.github.kaydunovDenis;

import com.github.kaydunovDenis.model.Person;
import com.github.kaydunovDenis.model.Skill;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
        System.out.println(findPersonHasNeedSkill(persons, "English"));

        System.out.println("Person has Kannada > 50%");
        System.out.println(findPersonHasNeedSkill(persons, "Kannada"));
    }

    private static Person findPersonHasNeedSkill(List<Person> persons, String language) {
        return persons.stream()
                .max(Comparator.comparingInt(person -> getProficiency(person, language)))
                .orElseThrow();
    }

    private static int getProficiency(Person person, String language) {
        return person.getSkills().stream()
                .filter(skill -> skill.getName().equals(language))
                .findAny()
                .orElseThrow()
                .getProficiency();
    }
}




