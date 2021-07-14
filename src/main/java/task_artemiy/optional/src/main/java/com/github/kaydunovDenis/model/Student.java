package com.github.kaydunovDenis.model;

import lombok.Data;

@Data
public class Student extends Person {

    public Student(String firstName, String lastName, Integer age) {
        super(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
