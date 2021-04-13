package com.github.kaydunovDenis.crud.service;

public class ErrorCommandException extends Exception {
    public ErrorCommandException(String message) {
        System.out.println(message);
        //TODO нужно разобраться как это вывести не через sout а через UserConsole
    }

    public ErrorCommandException() {
        System.out.println("Error command. Write command according the menu.\n" +
                "Example commands:\n" +
                "-r 0\n" +
                "-ra\n" +
                "-c SuperPhone 100.0 PHONE");
    }
}
