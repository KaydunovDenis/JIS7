package com.github.kaydunovDenis.model;

import java.util.Random;

public enum Time {
    TIME_10("10:00"),
    TIME_11("11:00"),
    TIME_14("14:00"),
    TIME_15("15:00");

    String timeText;

    Time(String timeText) {
        this.timeText = timeText;
    }

    public static Time getRandomTime() {
        Random random = new Random();
        return Time.values()[random.nextInt(Special.values().length)];
    }

    @Override
    public String toString() {
        return timeText;
    }
}
