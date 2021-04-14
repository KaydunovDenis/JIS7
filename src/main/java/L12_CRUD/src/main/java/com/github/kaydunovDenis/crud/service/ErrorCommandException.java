package com.github.kaydunovDenis.crud.service;

public class ErrorCommandException extends Exception {
    private String message = "";

    public ErrorCommandException(String message) {
        this.message = message;
    }

    public ErrorCommandException() {
    }

    @Override
    public String toString() {
        if (message.equals("")) {
            return "Error command. Write command according the menu.\n" +
                    "Example commands:\n" +
                    "-r 0\n" +
                    "-ra\n" +
                    "-c SuperPhone 100.0 PHONE";
        } else {
            return message;
        }
    }
}
