package com.hospital.exceptions.UserExceptions;

import com.hospital.exceptions.patientExceptions.PatientExceptionResponse;
import com.hospital.exceptions.patientExceptions.PatientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class UserExceptionHandler {



    @ExceptionHandler(value = {UsernameAlreadyExistsException.class})
    public ResponseEntity handlePatientNotFound(PatientNotFoundException exception) {
        UsernameAlreadyExistsResponse response = new UsernameAlreadyExistsResponse(exception.getMessage());
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }
}
