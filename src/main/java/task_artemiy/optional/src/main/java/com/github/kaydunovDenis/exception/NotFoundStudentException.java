package com.github.kaydunovDenis.exception;

import lombok.extern.java.Log;

@Log
public class NotFoundStudentException extends RuntimeException{
    public NotFoundStudentException(String message) {
        super(message);
        log.info(message);
    }
}
