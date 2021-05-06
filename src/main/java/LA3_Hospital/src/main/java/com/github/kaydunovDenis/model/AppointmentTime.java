package com.github.kaydunovDenis.model;

import java.util.Random;

public enum AppointmentTime {
    TIME_10,
    TIME_11,
    TIME_14,
    TIME_15;

    public static AppointmentTime getRandomValue() {
        Random random = new Random();
        return AppointmentTime.values()[random.nextInt(Special.values().length)];
    }
}
