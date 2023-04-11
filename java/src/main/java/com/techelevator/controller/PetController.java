package com.techelevator.controller;

import com.techelevator.dao.JdbcPetDao;
import com.techelevator.dao.PetDao;
import com.techelevator.model.Pet;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("permitAll()")

public class PetController {

    private final PetDao petDao;

    public PetController(PetDao petDao) {
        this.petDao = petDao;
    }

    //TODO: add error handling and change to dto
    @GetMapping("/pets")
    public List<Pet> listPets(){
        return petDao.listAllPets();
    }

}
