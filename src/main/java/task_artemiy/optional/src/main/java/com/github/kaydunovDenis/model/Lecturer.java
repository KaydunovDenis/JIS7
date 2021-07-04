package com.github.kaydunovDenis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lecturer extends Person {
    private List<Student> students = new ArrayList<>();

    public Lecturer(String firstName, String lastName, Integer age) {
        super(firstName, lastName, age);
    }
}
