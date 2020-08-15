package com.test.hospital.repository;

import com.test.hospital.domain.Salary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepository extends CrudRepository<Salary, Long> {

    List<Salary> findAllByEmployee_Id(Long employeeId);
}
