package com.techelevator.dao;

import com.techelevator.model.Pet;

import java.security.Principal;
import java.util.List;

public interface PetDao {

    List<Pet> listAllPets();

    Pet getPetByID(int id);

    Integer addNewPet(Pet pet);

    Integer updatePet(Pet pet, int id);
}
