package com.test.hospital.exceptions.patientExceptions;

public class PatientExceptionResponse {
    private final String message;

    public PatientExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
