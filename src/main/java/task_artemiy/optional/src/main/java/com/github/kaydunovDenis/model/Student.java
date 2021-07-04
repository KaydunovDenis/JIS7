package com.github.kaydunovDenis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Person {
    public Student(String firstName, String lastName, Integer age) {
        super(firstName, lastName, age);
    }
}
