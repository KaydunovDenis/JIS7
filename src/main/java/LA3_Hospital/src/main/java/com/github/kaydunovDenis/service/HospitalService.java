package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.exception.PatientRecordException;
import com.github.kaydunovDenis.model.Patient;
import com.github.kaydunovDenis.model.Special;
import com.github.kaydunovDenis.model.Time;
import com.github.kaydunovDenis.repository.PatientRepository;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class HospitalService {
    private static final int STANDARD_NUMBER_PATIENTS_PER_HOUR = 2;
    private static final PatientRepository PATIENT_REPOSITORY = new PatientRepository();
    Logger log = Logger.getLogger(HospitalService.class);

    public void add(Patient patient) {
        validatePayment(patient);
        if (queueIsFree(patient)) {
            PATIENT_REPOSITORY.add(patient);
            log.info(patient.toString() + "\tMade an appointment.");
            return;
        }
        findAnotherTime(patient);
    }

    private void findAnotherTime(Patient patient) {
        int newOrdinalInAppointmentTime = getNewOrdinalInAppointmentTime(patient);
        patient.setTime(Time.values()[newOrdinalInAppointmentTime]);
        log.info(patient.toString() + "\tBusy. Finding another time.");
        add(patient);
    }

    private int getNewOrdinalInAppointmentTime(Patient patient) {
        int newOrdinalInAppointmentTime = patient.getTime().ordinal() + 1;
        if (newOrdinalInAppointmentTime >= Special.values().length - 1) {
            throw new PatientRecordException(patient.toString() + "\tThere are not places.");
        }
        return newOrdinalInAppointmentTime;
    }

    private void validatePayment(Patient patient) {
        if (!patient.isPaid()) {
            throw new PatientRecordException(patient.toString() + "\tDon't have the payment.");
        }
    }

    private boolean queueIsFree(Patient patient) {
        return calculateCounterEmptyPlaceInQueue(patient) > 0;
    }

    private int calculateCounterEmptyPlaceInQueue(Patient patient) {
        AtomicInteger counterEmptyPlaceInQueue = new AtomicInteger(STANDARD_NUMBER_PATIENTS_PER_HOUR);
        getPatientList().stream().
                filter(it -> it.getSpecial().equals(patient.getSpecial()) && it.getTime().equals(patient.getTime())).
                forEach(it -> counterEmptyPlaceInQueue.getAndDecrement());
        return counterEmptyPlaceInQueue.get();
    }

    public List<Patient> getPatientList() {
        return PATIENT_REPOSITORY.getPatientList();
    }

    public List<Patient> getListPatientBySpecial(Special special) {
        return getPatientList().stream()
                .filter(patient -> patient.getSpecial().equals(special))
                .collect(Collectors.toList());
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
