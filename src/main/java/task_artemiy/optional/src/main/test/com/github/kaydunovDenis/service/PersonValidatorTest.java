package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.model.Lecturer;
import com.github.kaydunovDenis.model.Person;
import com.github.kaydunovDenis.model.Student;
import org.junit.Assert;

public class PersonValidatorTest {
    private Person lecturer = new Lecturer("Ogrimar", "Orc", 46);
    private Person student = new Student("Student", "Univers", 21);
    private Person lecturerError = new Lecturer(null, "Orc", 46);
    private Person studentError1 = new Student("Stud1", null, 46);
    private Person studentError2 = new Student("Stud2", "Ivanov", null);

    @org.junit.Test
    public void validateEmptyValue() {
        Assert.assertTrue(PersonValidator.validate(lecturer));
        Assert.assertTrue(PersonValidator.validate(student));
        Assert.assertFalse(PersonValidator.validate(lecturerError));
        Assert.assertFalse(PersonValidator.validate(studentError1));
        Assert.assertFalse(PersonValidator.validate(studentError2));
    }
}