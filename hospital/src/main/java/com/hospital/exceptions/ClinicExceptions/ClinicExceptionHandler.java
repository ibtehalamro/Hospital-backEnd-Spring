package com.hospital.exceptions.ClinicExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ClinicExceptionHandler {


    @ExceptionHandler(value = {ClinicNameAlreadyExistsException.class})
    public ResponseEntity<ClinicExceptionResponse> handlePatientNotFound(ClinicNameAlreadyExistsException exception) {
        ClinicExceptionResponse response = new ClinicExceptionResponse(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}





