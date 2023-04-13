package com.techelevator.dao;

import com.techelevator.model.Pet;

import java.security.Principal;
import java.util.List;

public interface PetDao {

    List<Pet> listAllPets();

    Pet getPetByID(int id);

    Pet addNewPet(Pet pet);
}
