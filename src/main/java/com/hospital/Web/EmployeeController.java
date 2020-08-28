package com.hospital.Web;


import com.hospital.domain.Employee;
import com.hospital.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public ResponseEntity createEmployee(@RequestBody Employee employee) {

        Employee response = employeeService.createEmployee(employee);

        return new ResponseEntity(response, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity getEmployeeById(@PathVariable Long id) {

        Employee employee = employeeService.getEmployeeById(id);

        return new ResponseEntity(employee, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployeeById(@PathVariable Long id) {

        employeeService.deleteEmployeeByID(id);
        return new ResponseEntity("employee with id (" + id + ") has been deleted", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    private Iterable getEmployeesList() {
        return employeeService.getEmployeesList();
    }

    @GetMapping("/all/{role}")
    private Iterable getEmployeesList(@PathVariable String role) {
        return employeeService.getEmployeeListByRole(role);
    }


}
