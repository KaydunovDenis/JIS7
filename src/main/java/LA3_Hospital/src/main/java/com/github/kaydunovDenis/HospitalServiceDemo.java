package com.github.kaydunovDenis;

import com.github.kaydunovDenis.model.Special;
import com.github.kaydunovDenis.service.HospitalService;

public class HospitalServiceDemo {
    public static void main(String[] args) {
        HospitalService hospitalService = new HospitalService();
        hospitalService.addTestPatients(100);
        System.out.println();
        HospitalService.PATIENT_REPOSITORY.getPatientList().forEach(System.out::println);
        System.out.println();

        hospitalService.getListPatientBySpecial(Special.NEUROLOGIST).stream().
                sorted().forEach(System.out::println);
    }
}

