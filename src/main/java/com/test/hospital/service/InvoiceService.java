package com.test.hospital.service;

import com.test.hospital.domain.Invoice;
import com.test.hospital.repository.InvoiceRepository;
import com.test.hospital.repository.WaitingQueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private WaitingQueueRepository waitingQueueRepository;

    @Transactional
    public Invoice createInvoice(Invoice invoice) {

        return invoiceRepository.save(invoice);
    }


    public Invoice getInvoiceById(Long id) {

        return invoiceRepository.findById(id).get();
    }

    public List<Invoice> getInvoicesListForPatientID(Long patientID) {
        return invoiceRepository.findAllByPatient_Id(patientID);
    }

    public void deleteInvoiceByID(Long id) {
        invoiceRepository.deleteById(id);
    }


}
