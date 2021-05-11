package com.github.kaydunovDenis;

import com.github.kaydunovDenis.model.Special;
import com.github.kaydunovDenis.service.HospitalService;

public class HospitalServiceDemo {
    public static void main(String[] args) {
        System.out.println("Demonstration of the registration patient");
        HospitalService hospitalService = new HospitalService();
        hospitalService.addTestPatients(100);

        System.out.println("Patient list:");
        hospitalService.getPatientList().forEach(System.out::println);

        System.out.println("List of patients by category:");
        hospitalService.getListPatientBySpecial(Special.NEUROLOGIST).stream().
                sorted().forEach(System.out::println);
    }
}

