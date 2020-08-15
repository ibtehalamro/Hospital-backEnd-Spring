package com.test.hospital.repository;

import com.test.hospital.domain.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
    List<Invoice> findAllByPatient_Id(Long patient_id);


}
