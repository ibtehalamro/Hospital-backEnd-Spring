package com.hospital.service;

import com.hospital.domain.Patient;
import com.hospital.exceptions.patientExceptions.PatientAlreadyExistException;
import com.hospital.exceptions.patientExceptions.PatientNotFoundException;
import com.hospital.repository.PatientRepository;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public Patient createPatient(Patient patient) {


        return patientRepository.save(patient);
}



    public  List<Patient>  createPatientFamily( List<Patient>  patient) {
        return (List<Patient>) patientRepository.saveAll(patient);
    }

    public Patient getPatientById(Long id) {

        return patientRepository.findById(id).get();
    }

    public Page<Patient> getPatientsList(Pageable pageable) {
        return patientRepository.findAll(PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(), Sort.by("id").ascending()));
    }

    @Transactional
    public void deltePatientByID(Long id) {
        patientRepository.deleteById(id);
    }

    public List<Patient> searchPatientName(String searchText) {

        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Patient.class)
                .get();

        org.apache.lucene.search.Query luceneQuery = queryBuilder
                .keyword()
                .onField( "person.personName.firstName" )
                .matching(searchText )
                .createQuery();


        FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, Patient.class);
        if (jpaQuery.getResultList().isEmpty())
            throw new PatientNotFoundException("Patient with name: " + searchText + " not found");

        return jpaQuery.getResultList();

    }
    public long getCountOfPatients(){
        return patientRepository.count();
    }
}
