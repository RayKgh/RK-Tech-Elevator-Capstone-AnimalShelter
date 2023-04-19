package com.techelevator.dao;

import com.techelevator.model.Pet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.List;

public class JdbcPetDaoTests extends BaseDaoTests{
    private final Pet PET_1 = new Pet(1,"name1","2011-11-11","test","test",false,"test","Adopted","2011-11-11","2011-11-11","test");
    private final Pet PET_2 = new  Pet(2,"name2","2011-11-11","test","test",false,"test","Adopted","2011-11-11","2011-11-11","test");
    private final Pet NEW_PET = new Pet(3,null,null,null,null,false,null,"Available",LocalDate.now().toString(),null,null);
    private final Pet UPDATED_PET = new  Pet(2,"updatedName","2011-11-11","test","test",false,"test","Available","2011-11-11",null,"test");

    private JdbcPetDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcPetDao(jdbcTemplate);
    }

    @Test
    public void listAllPets_returns_all(){
        List<Pet> pets = sut.listAllPets();

        Assert.assertNotNull(pets);
        Assert.assertEquals(2, pets.size());
        assertPetsMatch(PET_1, pets.get(0));
        assertPetsMatch(PET_2, pets.get(1));
    }

    @Test
    public void testing_add_new_pet(){
        Pet pet = new Pet();
        pet.setAdoptionStatus("Available");
        pet.setVaccinated(false);
        int petID = sut.addNewPet(pet);

        Assert.assertNotNull(sut.getPetByID(petID));
        assertPetsMatch(NEW_PET,sut.getPetByID(petID));
    }

    @Test
    public void testing_update_pet(){
        Pet pet = new  Pet(2,"name2","2011-11-11","test","test",false,"test","Adopted","2011-11-11",null,"test");
        pet.setAdoptionStatus("Available");
        pet.setVaccinated(false);
        pet.setPetName("updatedName");
        int petID = sut.updatePet(pet, 2);

        Assert.assertNotNull(sut.getPetByID(petID));
        assertPetsMatch(UPDATED_PET,sut.getPetByID(petID));
    }

    //need this because Assert.assertEquals compares references of two objects not values
    private void assertPetsMatch(Pet expected,Pet actual){
        Assert.assertEquals(expected.getPetID(),actual.getPetID());
        Assert.assertEquals(expected.getPetName(),actual.getPetName());
        Assert.assertEquals(expected.getDOB(),actual.getDOB());
        Assert.assertEquals(expected.getBreed(),actual.getBreed());
        Assert.assertEquals(expected.getColor(),actual.getColor());
        Assert.assertEquals(expected.isVaccinated(),actual.isVaccinated());
        Assert.assertEquals(expected.getSex(),actual.getSex());
        Assert.assertEquals(expected.getAdoptionStatus(),actual.getAdoptionStatus());
        Assert.assertEquals(expected.getEntryDate(),actual.getEntryDate());
        Assert.assertEquals(expected.getAdoptionDate(),actual.getAdoptionDate());
        Assert.assertEquals(expected.getPetDescription(),actual.getPetDescription());
    }
}
