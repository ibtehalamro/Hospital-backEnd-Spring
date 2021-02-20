package com.hospital.repository;

import com.hospital.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> , PagingAndSortingRepository<Employee, Long> {
    List<Employee> findAllByRole(String role);
}
