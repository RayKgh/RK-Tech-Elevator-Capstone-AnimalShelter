package com.techelevator.dao;

import com.techelevator.model.Pet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class JdbcPetDaoTests extends BaseDaoTests{
    protected static final Pet PET_1 = new Pet(1,"name1",  "test", "test", false,"test", "test",  "test");
    protected static final Pet PET_2 = new Pet(2,"name2", "test", "test", true, "test", "test",  "test");


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
        Assert.assertEquals(PET_1, pets.get(0));
        Assert.assertEquals(PET_2, pets.get(1));

    }
}
