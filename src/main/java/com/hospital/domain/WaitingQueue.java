package com.hospital.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Entity
public class WaitingQueue {

    /*********************
     *
     * fields
     *
     **********************/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clinic;
    private String patientFullName;
    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Employee employee;

    @CreationTimestamp
    private LocalTime localTime;
    @Temporal(TemporalType.DATE)
    Date createdAt;

    /*********************
     *
     * constructors
     *
     **********************/
    public WaitingQueue() {
    }

    @PrePersist
    public void setCreationDate(){
        createdAt=new Date(System.currentTimeMillis());
    }


    /*********************
     *
     * getters and setters
     *
     **********************/
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public String getPatientFullName() {
        return patientFullName;
    }

    public void setPatientFullName(String patientFullName) {
        this.patientFullName = patientFullName;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }
}

