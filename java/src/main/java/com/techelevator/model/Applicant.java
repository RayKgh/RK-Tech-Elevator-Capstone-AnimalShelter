package com.techelevator.model;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;

public class Applicant {
    private int applicationId;
    private LocalDate date;
    private String status;
    private String firstName;
    private String lastName;
    private String dob;
    private String phoneNum;
    private String email;

    public Applicant() {}

    public Applicant(int applicationId, LocalDate date, String status, String firstName, String lastName, String dob, String phoneNum, String email) {
        this.applicationId = applicationId;
        this.date = date;
        this.status = status;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public int getApplicationId() {
        return applicationId;
    }



    public LocalDate getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDob() {
        return dob;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
