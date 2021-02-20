package com.hospital.repository;

import com.hospital.domain.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

    List<Invoice> findAllByPatient_Id(Long patient_id);
    List<Invoice> findAllByIssuedAtBetween(Timestamp start, Timestamp end);
    List<Invoice> findAllByDoctorId(Long doctorId);
}
