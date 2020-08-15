package com.test.hospital.Web;

import com.test.hospital.domain.Patient;
import com.test.hospital.service.ErrorValidationMapService;
import com.test.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private ErrorValidationMapService errorMap;

    @PostMapping("/")
    public ResponseEntity createPatient(@Valid @RequestBody Patient patient, BindingResult result) {

        ResponseEntity<?> errors = errorMap.ErrorValidationMap(result);

        if (errors != null)
            return errors;

        Patient response = patientService.createPatient(patient);

        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PostMapping("/family")
    public ResponseEntity createPatientFamily(@Valid @RequestBody List<Patient> patient, BindingResult result) {

        ResponseEntity<?> errors = errorMap.ErrorValidationMap(result);

        if (errors != null)
            return errors;

        List<Patient>  response = patientService.createPatientFamily(patient);

        return new ResponseEntity(response, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")

    public ResponseEntity getPatientById(@PathVariable Long id) {

        Patient patient = patientService.getPatientById(id);

        return new ResponseEntity(patient, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePatientById(@PathVariable Long id) {

        patientService.deltePatientByID(id);
        return new ResponseEntity("patient with id (" + id + ") has been deleted", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    private ResponseEntity<Page<Patient>> getPatientsList(Pageable pageable) {
        return new ResponseEntity(patientService.getPatientsList(pageable), HttpStatus.CREATED);
    }

    @GetMapping("/name/{name}")
    private Iterable names(@PathVariable String name) {

        return patientService.searchPatientName(name);
    }

}
