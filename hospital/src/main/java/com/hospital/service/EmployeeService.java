package com.hospital.service;


import com.hospital.domain.Employee;
import com.hospital.domain.Patient;
import com.hospital.exceptions.patientExceptions.PatientNotFoundException;
import com.hospital.repository.EmployeeRepository;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @PersistenceContext
    private EntityManager entityManager;
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    public Employee getEmployeeById(Long id) {

        return employeeRepository.findById(id).get();
    }

    public Iterable<Employee> getEmployeesList(Pageable pageable) {

        return employeeRepository.findAll(PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(), Sort.by("id").ascending()));

    }

    public Iterable getEmployeeListByRole(String role) {
        return employeeRepository.findAllByRole(role);
    }

    public void deleteEmployeeByID(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Patient> searchEmployeeName(String searchText) {

        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Employee.class)
                .get();

        org.apache.lucene.search.Query luceneQuery = queryBuilder
                .keyword()
                .onField( "person.personName.firstName" )
                .matching(searchText )
                .createQuery();


        FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, Employee.class);
        if (jpaQuery.getResultList().isEmpty())
            throw new PatientNotFoundException("Employee with name: " + searchText + " not found");

        return jpaQuery.getResultList();

    }
    public long getCountOfEmployess(){
        return employeeRepository.count();
    }
}
