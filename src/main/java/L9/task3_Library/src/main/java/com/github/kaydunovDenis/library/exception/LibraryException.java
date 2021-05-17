package com.github.kaydunovDenis.library.exception;

public class LibraryException extends RuntimeException{
    private String message;

    public LibraryException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LibraryException: " + message;
    }
}
