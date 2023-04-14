package com.techelevator.dao;

import com.techelevator.model.Applicant;

import java.util.List;

public interface ApplicantDao {
    void submitApplication(Applicant applicant);

    List<Applicant> getPendingApplicants();
}
