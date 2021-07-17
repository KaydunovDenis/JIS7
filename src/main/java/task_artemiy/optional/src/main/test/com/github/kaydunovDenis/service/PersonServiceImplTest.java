package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.exception.NullDataException;
import com.github.kaydunovDenis.model.Lecturer;
import org.junit.Assert;
import org.junit.Test;

public class PersonServiceImplTest {
    private PersonService personService = new PersonServiceImpl();

    @Test
    public void updatePerson() {

        var lecturer = new Lecturer("Ogrimar", "Orc", 46);
        String expected = "Maks";

        personService.updatePerson(lecturer, expected, "Orc", 46);
        String result = lecturer.firstName;
        Assert.assertEquals(expected, result);

        try {
            personService.updatePerson(lecturer, expected, "Orc", 0);
            Assert.fail();
        } catch (NullDataException e) {
            Assert.assertTrue(true);
        }
    }
}