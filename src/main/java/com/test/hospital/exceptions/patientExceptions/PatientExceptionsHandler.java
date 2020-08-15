package com.test.hospital.exceptions.patientExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class PatientExceptionsHandler {

    @ExceptionHandler(value = {PatientNotFoundException.class})
    public ResponseEntity handlePatientNotFound(PatientNotFoundException exception) {
        PatientExceptionResponse response = new PatientExceptionResponse(exception.getMessage());
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = {PatientAlreadyExistException.class})
    public ResponseEntity handlePatientAlreadyExists(PatientAlreadyExistException exception){
        PatientExceptionResponse response = new PatientExceptionResponse(exception.getMessage());
        return new ResponseEntity(response, HttpStatus.CONFLICT);
    }
}
