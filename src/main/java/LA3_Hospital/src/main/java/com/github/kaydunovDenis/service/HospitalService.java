package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.model.AppointmentTime;
import com.github.kaydunovDenis.model.Patient;
import com.github.kaydunovDenis.model.Special;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HospitalService implements HospitalServiceRepository {
    private static final int NUMBER_PATIENTS_PER_HOUR = 2;
    private static final List<Patient> patientList = new ArrayList<>();
    Logger log = Logger.getLogger(HospitalService.class);

    @Override
    public void add(Patient patient) {
        if (!patient.isPaid()) {
            log.info(patient.toString() + " don't have the payment.");
            return;
        }
        if (queueIsFree(patient)) {
            patientList.add(patient);
            log.info(patient.toString() + " made an appointment.");
            return;
        }

        int newOrdinalInAppointmentTime = patient.getAppointmentTime().ordinal() + 1;
        if (newOrdinalInAppointmentTime >= Special.values().length - 1) {
            log.info(patient.toString() + " There are not places.");
            return;
        }
        patient.setAppointmentTime(AppointmentTime.values()[newOrdinalInAppointmentTime]);
        log.info(patient.toString() + "  is busy. Finding another time.");
        add(patient);
    }

    private void checkDifferentTime(Patient patient) {

    }

    private boolean queueIsFree(Patient patient) {
        boolean isFree = false;
        if (calculateCounterEmptyPlaceInQueue(patient) > 0) {
            isFree = true;
        }
        return isFree;
    }

    private int calculateCounterEmptyPlaceInQueue(Patient patient) {
        int counterEmptyPlaceInQueue = NUMBER_PATIENTS_PER_HOUR;
        for (Patient item : patientList) {
            if (item.getSpecial().equals(patient.getSpecial()) &&
                    item.getAppointmentTime().equals(patient.getAppointmentTime())) {
                counterEmptyPlaceInQueue--;
            }
        }
        return counterEmptyPlaceInQueue;
    }

    @Override
    public List<Patient> getPatientList() {
        return patientList;
    }

    @Override
    public List<Patient> getListPatientBySpecial(Special special) {
        List<Patient> tempListPatient = new ArrayList<>();
        for (Patient item : patientList) {
            if (item.getSpecial().equals(special)) {
                tempListPatient.add(item);
            }
        }
        return tempListPatient;
    }

    public void addTestPatients(int countTestPatients) {
        Random random = new Random();
        String name;
        boolean isPaid;
        Special special;
        AppointmentTime appointmentTime;
        for (int i = 0; i < countTestPatients; i++) {
            name = "Name" + i;
            isPaid = random.nextBoolean();
            special = Special.getRandomValue();
            appointmentTime = AppointmentTime.getRandomValue();
            Patient patient;
            patient = new Patient(name, isPaid, special, appointmentTime);
            add(patient);
        }
    }
}
