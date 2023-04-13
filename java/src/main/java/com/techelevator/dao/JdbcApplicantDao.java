package com.techelevator.dao;


import com.techelevator.model.Applicant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class JdbcApplicantDao implements ApplicantDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcApplicantDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void submitApplication(Applicant applicant) {
        applicant.setDate(LocalDate.now());

        String sql = "INSERT INTO applications(application_date, first_name, last_name, DOB, phone_number, email_address) "
                    + "VALUES(?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, applicant.getDate(), applicant.getFirstName(), applicant.getLastName(), applicant.getDob(), applicant.getPhoneNum(), applicant.getEmail());
    }

}
