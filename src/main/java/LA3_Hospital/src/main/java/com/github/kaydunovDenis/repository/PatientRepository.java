package com.github.kaydunovDenis.repository;

import com.github.kaydunovDenis.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientRepository {
    private static final List<Patient> patientList = new ArrayList<>();

    public void add(Patient patient) {
        patientList.add(patient);
    }

    public List<Patient> getPatientList() {
        return patientList;
    }
}
