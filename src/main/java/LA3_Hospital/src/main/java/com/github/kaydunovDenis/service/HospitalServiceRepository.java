package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.model.Patient;
import com.github.kaydunovDenis.model.Special;

import java.util.List;

public interface HospitalServiceRepository {
    void add(Patient patient);

    List<Patient> getPatientList();

    List<Patient> getListPatientBySpecial(Special special);
}
