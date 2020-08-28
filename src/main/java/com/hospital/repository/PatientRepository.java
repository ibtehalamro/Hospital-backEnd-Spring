package com.hospital.repository;


import com.hospital.domain.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PatientRepository extends CrudRepository<Patient, Long>, PagingAndSortingRepository<Patient, Long> {
        List<Patient> getPatientByPerson_SocialNumber(int num);


}
