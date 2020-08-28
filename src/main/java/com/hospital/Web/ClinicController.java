package com.hospital.Web;

import com.hospital.domain.Clinic;
import com.hospital.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/clinic")
public class ClinicController {

    @Autowired
    private ClinicService clinicService;

    @PostMapping("/")
    public ResponseEntity createClinic(@RequestBody Clinic clinic) {

        Clinic response = clinicService.createClinic(clinic);

        return new ResponseEntity(response, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity getClinicById(@PathVariable Long id) {

        Clinic clinic = clinicService.getClinicById(id);

        return new ResponseEntity(clinic, HttpStatus.CREATED);
    }

    @GetMapping("/queue/{clinic}")
    public ResponseEntity getClinicById(@PathVariable String clinic) {


        return new ResponseEntity(clinicService.getQueueNumber(clinic), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteClinicById(@PathVariable Long id) {

        clinicService.deleteClinicByID(id);
        return new ResponseEntity("clinic with id (" + id + ") has been deleted", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    private Iterable getClinicsList() {
        return clinicService.getClinicsList();
    }

}
