package com.hospital.domain.emeddable;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Embeddable
public class Person {

    /*********************
     *
     * fields
     *
     **********************/
    @IndexedEmbedded(depth = 1)
    @Embedded
    @Valid
    private Name personName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Date of birth should be provided (format: YYYY-MM-DD)")
    private Date dateOfBirth;
    @NotNull(message = "Gender should be provided ")
    private boolean gender;
    private String village;
    @NotBlank(message = "Mobile number must be provided")
    private String mobileNumber;

    private int socialNumber;

    /*********************
     *
     * constructors
     *
     **********************/
    public Person() {
    }
    /*********************
     *
     * getters and setters
     *
     **********************/

    public Name getPersonName() {
        return personName;
    }

    public void setPersonName(Name personName) {
        this.personName = personName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }


    public int getSocialNumber() {
        return socialNumber;
    }

    public void setSocialNumber(int socialNumber) {
        this.socialNumber = socialNumber;
    }

}
