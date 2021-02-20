package com.hospital.Web;

import com.hospital.domain.Invoice;
import com.hospital.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;


    @PostMapping("/")
    public ResponseEntity createInvoice(@RequestBody Invoice invoice) {

        Invoice response = invoiceService.createInvoice(invoice);
        //TODO delete patient from waiting queue once an invoice is stored

        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getInvoiceById(@PathVariable Long id) {

        Invoice invoice = invoiceService.getInvoiceById(id);

        return new ResponseEntity(invoice, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteInvoiceById(@PathVariable Long id) {

        invoiceService.deleteInvoiceByID(id);
        return new ResponseEntity("invoice with id (" + id + ") has been deleted", HttpStatus.CREATED);
    }

    @GetMapping("/all/{patientId}")
    private Iterable getInvoicesList(@PathVariable Long patientId) {

        return invoiceService.getInvoicesListForPatientID(patientId);
    }

 @GetMapping("/doctor/{doctorId}")
    private Iterable getPatientsTreatedByDoctorList(@PathVariable Long doctorId) {

        return invoiceService.getPatientsTreatedByDoctor(doctorId);
    }


}