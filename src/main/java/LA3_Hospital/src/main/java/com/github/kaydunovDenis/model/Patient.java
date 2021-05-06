package com.github.kaydunovDenis.model;

import lombok.Data;

import java.util.Comparator;

@Data
public class Patient implements Comparable<Patient> {
    private String name;
    private boolean isPaid;
    private Special special;
    private AppointmentTime appointmentTime;

    public Patient(String name, boolean isPaid, Special special, AppointmentTime appointmentTime) {
        this.name = name;
        this.isPaid = isPaid;
        this.special = special;
        this.appointmentTime = appointmentTime;
    }

    @Override
    public String toString() {
        return "Patient " + getName() +
                " with " + getSpecial() +
                " at " + getAppointmentTime();
    }


    @Override
    public int compareTo(Patient o) {
        return appointmentTime.compareTo(o.appointmentTime);
    }
}
