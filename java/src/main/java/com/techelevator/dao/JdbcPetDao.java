package com.techelevator.dao;

import com.techelevator.model.Pet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPetDao implements PetDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcPetDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Pet> listAllPets() {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pets";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()){
            Pet pet = mapRowToPet(results);
            pets.add(pet);
        }
        return pets;
    }

    public Pet getPetByID(int id){
        Pet pet = new Pet();
        String sql = "SELECT * FROM pets WHERE pet_id =?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,id);
        return pet;
    }

    public Pet addNewPet(Pet pet){
        if(pet==null){
            throw new IllegalArgumentException();
        }

        String sql = "INSERT INTO pets(pet_name, DOB, breed, color, sex, adoption_status, is_vaccinated, entry_date, pet_description) VALUES(?,?,?,?,?,?,?,?,?) RETURNING pet_id;";
        Integer newPetID = jdbcTemplate.queryForObject(sql,Integer.class,pet.getPetName(), LocalDate.parse(pet.getDOB()),pet.getBreed(),pet.getColor(),pet.getSex(),"Available",pet.isVaccinated(),LocalDate.now(),pet.getPetDescription());
        if(newPetID!=null){
            return getPetByID(newPetID);
        } else {
            return null;
        }
    }

    private Pet mapRowToPet(SqlRowSet results){
        Pet pet = new Pet();
        pet.setPetID(results.getInt("pet_id"));
        pet.setPetName(results.getString("pet_name"));
        if(results.getDate("DOB")!=null) {
            pet.setDOB(results.getString("DOB"));
        }
        pet.setBreed(results.getString("breed"));
        pet.setColor(results.getString("color"));
        pet.setSex(results.getString("sex"));
        if(results.getString("adoption_status")!=null){
            pet.setAdoptionStatus(results.getString("adoption_status"));
        }
        pet.setVaccinated(results.getBoolean("is_vaccinated"));

        if(results.getString("entry_date")!=null){
        pet.setEntryDate(results.getString("entry_date"));
        }

        if(results.getString("adoption_date")!=null) {
            pet.setAdoptionDate(results.getString("adoption_date"));
        }
        pet.setPetDescription(results.getString("pet_description"));

        return pet;
    }
}
