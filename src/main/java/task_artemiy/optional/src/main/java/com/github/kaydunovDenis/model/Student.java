package com.github.kaydunovDenis.model;

import lombok.Data;

@Data
public class Student extends Person {
    private static Long counterID = 0L;
    private Long id;

    public Student(String firstName, String lastName, Integer age) {
        super(firstName, lastName, age);
        id = counterID++;
    }
}
