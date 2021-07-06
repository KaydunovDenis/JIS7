package com.github.kaydunovDenis.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Lecturer extends Person {
    private List<Student> students = new ArrayList<>();

    public Lecturer(String firstName, String lastName, Integer age) {
        super(firstName, lastName, age);
    }
}
