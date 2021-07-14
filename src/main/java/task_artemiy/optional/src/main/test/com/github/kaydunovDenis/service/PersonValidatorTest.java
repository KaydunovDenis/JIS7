package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.model.Lecturer;
import com.github.kaydunovDenis.model.Person;

import static org.junit.Assert.*;

public class PersonValidatorTest {
    private Person lecturer = new Lecturer("Ogrimar", "Orc", 46);

    @org.junit.Test
    public void validateEmptyValue() {
        PersonValidator.validateEmptyValue()
    }
}