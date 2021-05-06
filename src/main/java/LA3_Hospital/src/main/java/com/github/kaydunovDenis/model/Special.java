package com.github.kaydunovDenis.model;

import java.util.Random;

public enum Special {
    THERAPIST("ТЕРАПЕВТ"),
    SURGEON("ХИРУРГ"),
    NEUROLOGIST("НЕВРОЛОГ"),
    OTOLARYNGOLOGIES("ОТОРИНОЛАРИНГОЛОГ");

    String doctor ;

    Special(String doctor) {
        this.doctor = doctor;
    }

    public static Special getRandomValue() {
        Random random = new Random();
        return Special.values()[random.nextInt(Special.values().length)];
    }
}