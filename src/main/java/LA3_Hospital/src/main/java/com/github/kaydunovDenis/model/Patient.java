package com.github.kaydunovDenis.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Patient implements Comparable<Patient> {
    private String name;
    private boolean isPaid;
    private Special special;
    private Time time;
    private static final String TEMPLATE = "Patient\t%s:\t%-" + Special.MAX_LENGTH_FIELD_STRING_DOCTOR + "s %s";

    @Override
    public String toString() {
        return String.format(TEMPLATE, getName(), getSpecial(), getTime());
    }

    @Override
    public int compareTo(Patient o) {
        return time.compareTo(o.time);
    }
}
