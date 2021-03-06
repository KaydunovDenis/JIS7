package com.github.kaydunovDenis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private long id;
    private String name;
    private Set<Skill> skills;

    public Person(long id, String name, Skill... skills) {
        this.id = id;
        this.name = name;
        this.skills = Set.of(skills);
    }

    @Override
    public String toString() {
        return String.format("%d:%s {%s}", id, name, skills);
    }
}
