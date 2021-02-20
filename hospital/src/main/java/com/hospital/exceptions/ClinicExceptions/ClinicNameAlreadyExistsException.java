package com.hospital.exceptions.ClinicExceptions;

public class ClinicNameAlreadyExistsException extends RuntimeException{
    public ClinicNameAlreadyExistsException(String message) {
        super(message);
    }
}
