package com.techelevator.dao;

import com.techelevator.model.Pet;
import com.techelevator.model.Photo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.parameters.P;
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
        String sql = "SELECT * FROM pets WHERE pet_id = ? ;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,id);
        if(result.next()){
            pet = mapRowToPet(result);
        }
        return pet;

    }

    public Integer addNewPet(Pet pet){
        if(pet==null){
            throw new IllegalArgumentException();
        }

        String sql = "INSERT INTO pets(pet_name, DOB, breed, color, sex, adoption_status, is_vaccinated, entry_date, pet_description) VALUES(?,?,?,?,?,?,?,?,?) RETURNING pet_id;";
        Integer newPetID = jdbcTemplate.queryForObject(sql,Integer.class,pet.getPetName(), (pet.getDOB()!=null) ? LocalDate.parse(pet.getDOB()) : null, pet.getBreed(),pet.getColor(),pet.getSex(),"Available",pet.isVaccinated(),LocalDate.now(),pet.getPetDescription());
        if(newPetID!=null){
            return newPetID;
        } else {
            return null;
        }
    }

    public Integer updatePet(Pet pet, int id){
        if(pet==null){
            throw new IllegalArgumentException();
        }

        String sql = "UPDATE pets\n" +
                "\tSET pet_name=?, dob=?, breed=?, color=?, sex=?, adoption_status=?, is_vaccinated=?, entry_date=?, adoption_date=?, pet_description=?\n" +
                "\tWHERE pet_id=? RETURNING pet_id;";

        Integer updatedPetID = jdbcTemplate.queryForObject(sql,Integer.class,pet.getPetName(),(pet.getDOB()!=null) ? LocalDate.parse(pet.getDOB()) : null,pet.getBreed(),pet.getColor(),pet.getSex(),pet.getAdoptionStatus(),pet.isVaccinated(),(pet.getEntryDate()!=null) ? LocalDate.parse(pet.getEntryDate()) : null,(pet.getAdoptionDate()!=null) ? LocalDate.parse(pet.getAdoptionDate()) : null,pet.getPetDescription(),id);
        Photo photo = new Photo();
        photo.setPetID(updatedPetID);
        photo.setDescription(pet.getPhotoDescription());
        photo.setSource(pet.getSource());
        if(updatedPetID!=null){

            return updatedPetID;
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
