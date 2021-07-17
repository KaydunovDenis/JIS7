package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.exception.PatientRecordException;
import com.github.kaydunovDenis.model.Patient;
import com.github.kaydunovDenis.model.Special;
import com.github.kaydunovDenis.model.Time;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class HospitalServiceTest extends TestCase {
    private static HospitalService hospitalService;
    Patient patient = new Patient("Denis", true, Special.NEUROLOGIST, Time.TIME_15);
    int expect;
    int result;

    @BeforeEach
    void beforeEach() {
        System.out.println("before");
        hospitalService = new HospitalService();
        hospitalService.getPatientList().clear();
        System.out.println(hospitalService.getPatientList().size());
    }

    @Test
    void add() {
        hospitalService = new HospitalService();
        expect = 0;
        result = hospitalService.getPatientList().size();
        System.out.println(result);
        Assert.assertEquals(expect, result);

        hospitalService.add(patient);
        expect = 1;
        result = hospitalService.getPatientList().size();
        Assert.assertEquals(expect, result);

        hospitalService.add(patient);
        expect = 2;
        result = hospitalService.getPatientList().size();
        Assert.assertEquals(expect, result);

        String expectMessage = "Patient Denis with neurologist at 15:00. There are not places.";
        String resultMessage = "";
        try {
            hospitalService.add(patient);
        } catch (PatientRecordException e) {
            resultMessage = e.getMessage();
        }
        expect = 2;
        result = hospitalService.getPatientList().size();
        Assert.assertEquals(expect, result);
        Assert.assertEquals(expectMessage, resultMessage);
    }

    @Test
    void getListPatientBySpecial() {
        List<Patient> listExpect = new ArrayList<>();
        listExpect.add(patient);
        hospitalService.add(patient);
        List<Patient> listResult = hospitalService.getListPatientBySpecial(Special.NEUROLOGIST);
        Assert.assertEquals(listExpect, listResult);
    }

    @Test
    void addTestPatients() {
        expect = 5;
        hospitalService.addTestPatients(5);
        result = hospitalService.getPatientList().size();
        Assert.assertTrue(expect >= result);
    }
}