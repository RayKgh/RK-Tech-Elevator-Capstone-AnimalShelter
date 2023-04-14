package com.techelevator.controller;

import com.techelevator.dao.JdbcPetDao;
import com.techelevator.dao.PetDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Authority;
import com.techelevator.model.Pet;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("permitAll()")
public class PetController {

    private final PetDao petDao;
    private final UserDao userDao;

    public PetController(PetDao petDao, UserDao userDao) {
        this.petDao = petDao;
        this.userDao = userDao;
    }

    @GetMapping("/pets")
    public List<Pet> listPets(){

        //check that something is returned
        if(petDao.listAllPets()==null){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Nothing pulled from database");
        }
        return petDao.listAllPets();
    }

    @PostMapping("/pets/add") 
    public void addPet(@RequestBody @Valid Pet pet, Principal principal) throws IllegalAccessException {

        User user = userDao.findByUsername(principal.getName());
        //the logged in user

        //check to see if the user has correct role
        if(user.getAuthorities().contains(new Authority("ROLE_USER")) || user.getAuthorities().contains(new Authority("ROLE_ADMIN"))){
            if(pet!=null){
//            Pet newPet = new Pet(pet.getPetID(),pet.getPetName(),pet.getDOB(),pet.getBreed(),pet.getColor(),pet.isVaccinated(),pet.getSex(),"Available", LocalDate.now(),null,pet.getPetDescription());
                pet.setAdoptionStatus("Available");
                pet.setEntryDate(LocalDate.now().toString());
                pet.setAdoptionDate(null);
                if(petDao.addNewPet(pet)==null){
                    throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED,"The pet was not added to the database");
                }
            }
        } else {
            throw new IllegalAccessException("Must be logged in to add a pet");
        }



    }

}
