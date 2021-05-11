package com.github.kaydunovDenis.exception;

public class PatientRecordException extends RuntimeException {
    private final String message;

    public PatientRecordException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "";
    }
}
