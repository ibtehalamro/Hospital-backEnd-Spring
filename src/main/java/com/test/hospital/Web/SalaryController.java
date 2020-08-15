package com.test.hospital.Web;

import com.test.hospital.domain.Salary;
import com.test.hospital.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @PostMapping("/")
    public ResponseEntity createSalary(@RequestBody Salary salary) {

        Salary response = salaryService.createSalary(salary);

        return new ResponseEntity(response, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity getSalaryById(@PathVariable Long id) {

        Salary salary = salaryService.getSalaryById(id);

        return new ResponseEntity(salary, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteSalaryById(@PathVariable Long id) {

        salaryService.deleteSalaryByID(id);
        return new ResponseEntity("salary with id (" + id + ") has been deleted", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    private Iterable getSalaryList() {
        return salaryService.getSalaryList();
    }

    @GetMapping("/employee/{id}")
    private Iterable getSalaryList(@PathVariable Long id) {
        return salaryService.getSalaryListByEmployeeId(id);
    }

}
