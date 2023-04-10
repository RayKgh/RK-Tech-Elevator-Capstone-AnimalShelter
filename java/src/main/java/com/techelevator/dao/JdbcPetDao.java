package com.techelevator.dao;

import com.techelevator.model.Pet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPetDao implements PetDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcPetDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Pet> listAllPets() {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pets;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()){
            Pet pet = mapRowToPet(results);
            pets.add(pet);
        }
        return pets;
    }

    private Pet mapRowToPet(SqlRowSet results){
        Pet pet = new Pet();
        pet.setPetID(results.getInt("pet_id"));
        pet.setName(results.getString("name"));
        pet.setDOB(results.getDate("DOB"));
        pet.setBreed(results.getString("breed"));
        pet.setColor(results.getString("color"));
        pet.setSex(results.getString("sex"));
        pet.setStatus(results.getString("status"));
        pet.setVaccinated(results.getBoolean("is_vaccinated"));
        pet.setEntryDate(results.getDate("entry_date"));
        if(results.getDate("adoption_date")==null){
            pet.setAdoptionDate(null);
        } else {
            pet.setAdoptionDate(results.getDate("adoption_date"));
        }
        pet.setDescription(results.getString("description"));

        return pet;
    }
}
