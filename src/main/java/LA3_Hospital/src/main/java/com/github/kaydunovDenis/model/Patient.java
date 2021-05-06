package com.github.kaydunovDenis.model;

import lombok.Data;

@Data
public class Patient {
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
}
