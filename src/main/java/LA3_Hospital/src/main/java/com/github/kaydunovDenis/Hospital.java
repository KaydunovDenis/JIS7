package com.github.kaydunovDenis;

import com.github.kaydunovDenis.service.HospitalService;

public class Hospital {
    public static void main(String[] args) {
        HospitalService patientRepository = new HospitalService();
        patientRepository.addTestPatients(100);
    }
}

