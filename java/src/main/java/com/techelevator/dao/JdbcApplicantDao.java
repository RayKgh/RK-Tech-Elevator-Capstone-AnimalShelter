package com.techelevator.dao;


import com.techelevator.model.Applicant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Applicant> getPendingApplicants() {
        List<Applicant> applicants = new ArrayList<>();
        String sql = "SELECT application_id, application_date, first_name, last_name, DOB, phone_number, email_address FROM applications WHERE status = 'pending'";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Applicant applicant = mapRowToApplicant(results);
            applicants.add(applicant);
        }
        return applicants;
    }

    @Override
    public void updateApplicantStatus(Applicant applicant) {
        String sql = "UPDATE applications SET status = ? WHERE application_id = ?";
        jdbcTemplate.update(sql, applicant.getStatus(), applicant.getApplicationId());
    }

    @Override
    public void addUser(Applicant applicant) {
        String username = applicant.getFirstName() + "." +applicant.getLastName();
        String role = "ROLE_USER";
        String password_hash = new BCryptPasswordEncoder().encode("password");

        String sql =    "INSERT INTO users(application_id, username, password_hash, role, first_name, last_name, dob, phone_number, email_address) "
                    +   "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, applicant.getApplicationId(), username, password_hash, role, applicant.getFirstName(), applicant.getLastName(),applicant.getDob(), applicant.getPhoneNum(), applicant.getEmail());
    }

    private Applicant mapRowToApplicant(SqlRowSet rowSet) {
        Applicant applicant = new Applicant();
        applicant.setApplicationId(rowSet.getInt("application_id"));
        applicant.setDate(rowSet.getDate("application_date").toLocalDate());
        applicant.setFirstName(rowSet.getString("first_name"));
        applicant.setLastName(rowSet.getString("last_name"));
        applicant.setDob(rowSet.getString("DOB"));
        applicant.setPhoneNum(rowSet.getString("phone_number"));
        applicant.setEmail(rowSet.getString("email_address"));
        return applicant;
    }

}
