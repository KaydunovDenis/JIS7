package com.github.kaydunovDenis;

import com.github.kaydunovDenis.model.Special;
import com.github.kaydunovDenis.service.HospitalService;

public class Hospital {
    public static void main(String[] args) {
        HospitalService patientRepository = new HospitalService();
        patientRepository.addTestPatients(50);
        System.out.println();
        patientRepository.getPatientList().forEach(System.out::println);
        System.out.println();

        patientRepository.getListPatientBySpecial(Special.NEUROLOGIST).stream().
                sorted().forEach(System.out::println);
    }
}

