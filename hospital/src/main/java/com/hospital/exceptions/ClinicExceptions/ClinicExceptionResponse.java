package com.hospital.exceptions.ClinicExceptions;

public class ClinicExceptionResponse {
    private final String message;

    public ClinicExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
