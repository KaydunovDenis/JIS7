package com.github.kaydunovDenis.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data()
public class Lecturer extends Person {
    private List<Student> students = new ArrayList<>();

    public Lecturer(String firstName, String lastName, Integer age) {
        super(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", students=" + students +
                '}';
    }
}
