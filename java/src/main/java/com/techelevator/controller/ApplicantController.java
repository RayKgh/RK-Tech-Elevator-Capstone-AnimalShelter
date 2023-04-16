package com.techelevator.controller;

import com.techelevator.dao.ApplicantDao;
import com.techelevator.model.Applicant;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class ApplicantController {
    private final ApplicantDao applicantDao;


    public ApplicantController(ApplicantDao applicantDao) {
        this.applicantDao = applicantDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/volunteer")
    public void submit(@RequestBody Applicant applicant){
        applicantDao.submitApplication(applicant);
    }

    @RequestMapping (path = "/applicants", method = RequestMethod.GET)
    public List<Applicant> listApplicants() {return applicantDao.getPendingApplicants();}

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/applicant")
    public void statusChange(@Valid @RequestBody Applicant applicant) {
        applicantDao.updateApplicantStatus(applicant);
        if (applicant.getStatus().equals("approved")) {
            applicantDao.addUser(applicant);
        }
    }

}
