package com.hospital.service;

import com.hospital.domain.Salary;
import com.hospital.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {


    @Autowired
    private SalaryRepository salaryRepository;

    public Salary createSalary(Salary salary) {
        return salaryRepository.save(salary);
    }


    public Salary getSalaryById(Long id) {

        return salaryRepository.findById(id).get();
    }

    public Iterable getSalaryList() {
        return salaryRepository.findAll();
    }

    public Iterable getSalaryListByEmployeeId(Long employeeId) {
        return salaryRepository.findAllByEmployee_Id(employeeId);
    }

    public void deleteSalaryByID(Long id) {
        salaryRepository.deleteById(id);
    }


}
