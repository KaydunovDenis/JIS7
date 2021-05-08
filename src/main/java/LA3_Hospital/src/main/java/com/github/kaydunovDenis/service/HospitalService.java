package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.exception.PatientRecordException;
import com.github.kaydunovDenis.model.Time;
import com.github.kaydunovDenis.model.Patient;
import com.github.kaydunovDenis.model.Special;
import com.github.kaydunovDenis.repository.PatientRepository;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HospitalService {
    private static final int NUMBER_PATIENTS_PER_HOUR = 2;
    public static final PatientRepository PATIENT_REPOSITORY = new PatientRepository();
    Logger log = Logger.getLogger(HospitalService.class);

    public void add(Patient patient) {
        validatePayment(patient);
        if (!queueIsFree(patient)) {
            findAnotherTime(patient);
        }
        PATIENT_REPOSITORY.add(patient);
        log.info(patient.toString() + " made an appointment.");
    }

    private void findAnotherTime(Patient patient) {
        int newOrdinalInAppointmentTime = getNewOrdinalInAppointmentTime(patient);
        patient.setTime(Time.values()[newOrdinalInAppointmentTime]);
        log.info(patient.toString() + "  is busy. Finding another time.");
        add(patient);
    }

    private int getNewOrdinalInAppointmentTime(Patient patient) {
        int newOrdinalInAppointmentTime = patient.getTime().ordinal() + 1;
        if (newOrdinalInAppointmentTime >= Special.values().length - 1) {
            throw new PatientRecordException(patient.toString() + ". There are not places.");
        }
        return newOrdinalInAppointmentTime;
    }

    private void validatePayment(Patient patient) {
        if (!patient.isPaid()) {
            throw new PatientRecordException(patient.toString() + " don't have the payment.");
        }
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
        for (Patient item : PATIENT_REPOSITORY.getPatientList()) {
            if (item.getSpecial().equals(patient.getSpecial()) &&
                    item.getTime().equals(patient.getTime())) {
                counterEmptyPlaceInQueue--;
            }
        }
        return counterEmptyPlaceInQueue;
    }

    public List<Patient> getListPatientBySpecial(Special special) {
        List<Patient> tempListPatient = new ArrayList<>();
        for (Patient item : PATIENT_REPOSITORY.getPatientList()) {
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
        Time time;
        for (int i = 0; i < countTestPatients; i++) {
            name = "Name" + i;
            isPaid = random.nextBoolean();
            special = Special.getRandomValue();
            time = Time.getRandomTime();
            Patient patient;
            patient = new Patient(name, isPaid, special, time);
            try {
                add(patient);
            } catch (PatientRecordException e) {
                log.error(e.getMessage());
            }
        }
    }
}
