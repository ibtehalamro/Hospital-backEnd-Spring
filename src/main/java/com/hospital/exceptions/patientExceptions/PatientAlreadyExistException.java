package com.hospital.exceptions.patientExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class PatientAlreadyExistException extends RuntimeException{
    public PatientAlreadyExistException(String message) {
        super(message);
    }
}
