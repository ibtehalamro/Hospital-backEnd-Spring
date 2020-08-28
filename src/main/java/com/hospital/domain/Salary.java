package com.hospital.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Salary {

    /*********************
     *
     * fields
     *
     **********************/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM")
    private Date salaryBayedForDate;
    @CreationTimestamp
    private Date issuedAt;
    private String notes;
    private double salaryValuePayed;
    private double salaryRemaining;


    @ManyToOne
    private Employee employee;


    /*********************
     *
     * constructors
     *
     **********************/
    public Salary() {
    }

    /*********************
     *
     * getters and setters
     *
     **********************/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSalaryBayedForDate() {
        return salaryBayedForDate;
    }

    public void setSalaryBayedForDate(Date salaryBayedForDate) {
        this.salaryBayedForDate = salaryBayedForDate;
    }

    public Date getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Date issuedAt) {
        this.issuedAt = issuedAt;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public double getSalaryValuePayed() {
        return salaryValuePayed;
    }

    public void setSalaryValuePayed(double salaryValuePayed) {
        this.salaryValuePayed = salaryValuePayed;
    }

    public double getSalaryRemaining() {
        return salaryRemaining;
    }

    public void setSalaryRemaining(double salaryRemaining) {
        this.salaryRemaining = salaryRemaining;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}


