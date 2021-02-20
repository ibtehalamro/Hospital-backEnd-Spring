package com.hospital.domain;

import com.hospital.domain.emeddable.Person;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.*;
@Indexed
@Entity
public class Employee {


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
    private Person person;

    private String role;
    private String certificate;
    private double salary;

    /*********************
     *
     * constructors
     *
     **********************/
    public Employee() {
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
