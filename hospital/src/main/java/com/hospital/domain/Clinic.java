package com.hospital.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Clinic {

    /*********************
     *
     * fields
     *
     **********************/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Clinic name should be provided")
    @Column(unique = true)
    private String clinicName;


    /*********************
     *
     * constructors
     *
     **********************/
    public Clinic() {
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

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }


}

