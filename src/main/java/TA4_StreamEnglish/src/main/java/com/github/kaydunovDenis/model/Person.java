package com.github.kaydunovDenis.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
public class Person {
    private long id;
    private String name;
    private List<Skill> skills = new ArrayList<>();

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
