package com.hospital.domain;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;


@Entity
public class Invoice {
    /*********************
     *
     * fields
     *
     **********************/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//id of this invoice

    @CreationTimestamp
    private Timestamp issuedAt;//when this invoice created this will be auto-generated when this invoice created

    private double charged;//amount that patient should pay
    private double amountPayed;
    private String description;
    private String treatment;
    private Date dateOfPayedFull; //generated when the dueAmount equal zero


    @ManyToOne
    private Patient patient;

    @Transient
    private double dueAmount;//what patient need to pay

    /*********************
     *
     * constructors and methods
     *
     **********************/

    public Invoice() {
    }

    @PreUpdate
    @PrePersist
    public void setData() {
        this.dueAmount = charged - amountPayed;
        if (dueAmount == 0) {
            dateOfPayedFull = new Date(System.currentTimeMillis());
        }
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

    public double getCharged() {
        return charged;
    }

    public void setCharged(double charged) {
        this.charged = charged;
    }

    public double getAmountPayed() {

        if (amountPayed != charged) {
            dueAmount = charged - amountPayed;
        }
        return amountPayed;
    }

    public void setAmountPayed(double amountPayed) {
        this.amountPayed = amountPayed;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Date getDateOfPayedFull() {
        return dateOfPayedFull;
    }

    public void setDateOfPayedFull(Date dateOfPayedFull) {
        this.dateOfPayedFull = dateOfPayedFull;
    }

    public double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public Timestamp getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Timestamp issuedAt) {
        this.issuedAt = issuedAt;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
}
