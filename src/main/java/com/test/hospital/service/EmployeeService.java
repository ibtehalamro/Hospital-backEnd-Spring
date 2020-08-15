package com.test.hospital.service;


import com.test.hospital.domain.Employee;
import com.test.hospital.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    public Employee getEmployeeById(Long id) {

        return employeeRepository.findById(id).get();
    }

    public Iterable getEmployeesList() {
        return employeeRepository.findAll();
    }

    public Iterable getEmployeeListByRole(String role) {
        return employeeRepository.findAllByRole(role);
    }

    public void deleteEmployeeByID(Long id) {
        employeeRepository.deleteById(id);
    }

}
