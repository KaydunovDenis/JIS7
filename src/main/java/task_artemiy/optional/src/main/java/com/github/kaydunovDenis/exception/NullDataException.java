package com.github.kaydunovDenis.exception;

import lombok.extern.java.Log;

@Log
public class NullDataException extends RuntimeException {
    public NullDataException(String message) {
        super(message);
        log.info(message);
    }
}
