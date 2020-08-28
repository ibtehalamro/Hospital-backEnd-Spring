package com.hospital.domain;

import com.hospital.domain.emeddable.Person;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.*;
import javax.validation.Valid;

@Indexed
@Entity
public class Patient {

    /*********************
     *
     * fields
     *
     **********************/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @IndexedEmbedded(depth = 2)
    @Embedded
    @Valid
    private Person person;
    private String allergies;

    private String socialStatus;
    private String educationLevel;
    private String jobTitle;
    private String chronicDisease;
    private String disability;
    private String partnerRelation;
    private boolean smoker;
    private String bloodGroup;

    /*********************
     *
     * constructors
     *
     **********************/
    public Patient() {
    }

    /*********************
     *
     * getters and setters
     *
     **********************/

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }


    public String getSocialStatus() {
        return socialStatus;
    }

    public void setSocialStatus(String socialStatus) {
        this.socialStatus = socialStatus;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getChronicDisease() {
        return chronicDisease;
    }

    public void setChronicDisease(String chronicDisease) {
        this.chronicDisease = chronicDisease;
    }

    public String getDisability() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public String getPartnerRelation() {
        return partnerRelation;
    }

    public void setPartnerRelation(String partnerRelation) {
        this.partnerRelation = partnerRelation;
    }

    public boolean isSmoker() {
        return smoker;
    }

    public void setSmoker(boolean smoker) {
        this.smoker = smoker;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
