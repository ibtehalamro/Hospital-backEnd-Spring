package com.hospital.repository;

import com.hospital.domain.Clinic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRepository extends CrudRepository<Clinic, Long> {

    Clinic getQueueNumberByClinicNameEquals(String clinicName);

}
