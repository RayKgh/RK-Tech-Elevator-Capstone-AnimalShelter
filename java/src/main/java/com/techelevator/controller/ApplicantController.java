package com.techelevator.controller;

import com.techelevator.dao.ApplicantDao;
import com.techelevator.model.Applicant;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ApplicantController {
    private final ApplicantDao applicantDao;


    public ApplicantController(ApplicantDao applicantDao) {
        this.applicantDao = applicantDao;
    }

    @PostMapping("/volunteer")
    public void submit(@RequestBody Applicant applicant){
        applicantDao.sumbitAppication(applicant);
    }
}
