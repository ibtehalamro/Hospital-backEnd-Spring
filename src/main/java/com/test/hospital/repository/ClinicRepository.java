package com.test.hospital.repository;

import com.test.hospital.domain.Clinic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRepository extends CrudRepository<Clinic, Long> {

    Clinic getQueueNumberByClinicNameEquals(String clinicName);

}
