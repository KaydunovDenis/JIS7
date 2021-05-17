package com.github.kaydunovDenis.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;

@Data
@NoArgsConstructor
public class Person {
    long id;
    String name;
    ArrayList<Skill> skills = new ArrayList<>();

    public Person(long id, String name, Skill ... skills) {
        this.id = id;
        this.name = name;
        this.skills.addAll(Arrays.asList(skills));
    }

    @Override
    public String toString() {
        return id +": name=" + name + ", skills: " + skills;
    }
}
