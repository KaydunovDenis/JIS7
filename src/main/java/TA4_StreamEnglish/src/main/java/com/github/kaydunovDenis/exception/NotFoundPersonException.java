package com.github.kaydunovDenis.exception;

import lombok.extern.java.Log;

@Log
public class NotFoundPersonException extends RuntimeException{
    public NotFoundPersonException() {
        log.info("The Person not found.");
    }
}
