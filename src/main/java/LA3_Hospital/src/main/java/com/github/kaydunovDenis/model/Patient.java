package com.github.kaydunovDenis.model;

import lombok.Data;

@Data
public class Patient implements Comparable<Patient> {
    private String name;
    private boolean isPaid;
    private Special special;
    private Time time;

    public Patient(String name, boolean isPaid, Special special, Time time) {
        this.name = name;
        this.isPaid = isPaid;
        this.special = special;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Patient " + getName() +
                " with " + getSpecial() +
                " at " + getTime();
    }

    @Override
    public int compareTo(Patient o) {
        return time.compareTo(o.time);
    }
}
