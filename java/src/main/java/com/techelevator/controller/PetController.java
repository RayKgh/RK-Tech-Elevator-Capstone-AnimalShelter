package com.techelevator.controller;

import com.techelevator.dao.JdbcPetDao;
import com.techelevator.dao.PetDao;
import com.techelevator.model.Pet;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("permitAll()")
public class PetController {

    private final PetDao petDao;

    public PetController(PetDao petDao) {
        this.petDao = petDao;
    }

    @GetMapping("/pets")
    public List<Pet> listPets(){

        //check that something is returned
        if(petDao.listAllPets()==null){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Nothing pulled from database");
        }
        return petDao.listAllPets();
    }

}
