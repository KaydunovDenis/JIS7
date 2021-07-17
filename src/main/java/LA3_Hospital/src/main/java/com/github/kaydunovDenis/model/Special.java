package com.github.kaydunovDenis.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public enum Special {
    THERAPIST("therapist"),
    SURGEON("surgeon"),
    NEUROLOGIST("neurologist"),
    OTOLARYNGOLOGIES("otolaryngologies");

    String doctor;
    public static final int MAX_LENGTH_FIELD_STRING_DOCTOR = Arrays.stream(Special.values())
            .max(Comparator.comparing(it -> it.doctor.length()))
            .orElseThrow()
            .doctor.length();

    Special(String doctor) {
        this.doctor = doctor;
    }

    public static Special getRandomValue() {
        Random random = new Random();
        return Special.values()[random.nextInt(Special.values().length)];
    }

    @Override
    public String toString() {
        return doctor;
    }
}