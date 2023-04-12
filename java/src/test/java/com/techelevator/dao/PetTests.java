package com.techelevator.dao;

import com.techelevator.model.Pet;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;


public class PetTests {

    private Pet pet = new Pet();

    @Test
    public void testPetAges(){
        this.pet.setDOB(LocalDate.of(1996,7,3));
        Assert.assertEquals(26,pet.getAge());
        this.pet.setDOB(LocalDate.of(2001,9,26));
        Assert.assertEquals(21,pet.getAge());
        this.pet.setDOB(LocalDate.of(2000,1,1));
        Assert.assertEquals(23,pet.getAge());
    }

    @Test
    public void testHowLongPetHasBeenInShelter(){
        this.pet.setEntryDate(LocalDate.of(1996,7,3));
        Assert.assertEquals(26,pet.getTimeInShelter());
    }


}
