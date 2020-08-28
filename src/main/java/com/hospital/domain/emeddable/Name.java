package com.hospital.domain.emeddable;


import org.hibernate.search.annotations.Field;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Embeddable
public class Name {

    /*********************
     *
     * fields
     *
     **********************/

    @Field
    @NotBlank(message = "First name should be provided")
    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    private String firstName;
    @NotBlank(message = "Parent name should be provided")
    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    private String parentName;
    @NotBlank(message = "Grand name should be provided")
    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    private String grandName;
    @NotBlank(message = "Family name should be provided")
    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    private String familyName;


    /*********************
     *
     * constructors
     *
     **********************/
    public Name() {
    }

    /*********************
     *
     * getters and setters
     *
     **********************/
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getGrandName() {
        return grandName;
    }

    public void setGrandName(String grandName) {
        this.grandName = grandName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
}
