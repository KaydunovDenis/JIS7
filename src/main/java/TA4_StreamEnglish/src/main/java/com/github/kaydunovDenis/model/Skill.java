package com.github.kaydunovDenis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
    private String name;
    private int proficiency;

    @Override
    public String toString() {
        return " " + name + " - " + proficiency + "%";
    }
}
