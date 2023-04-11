package com.techelevator.dao;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.techelevator.model.Photo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcPhotoDaoTests extends BaseDaoTests{
    private final Photo PHOTO_1 = new Photo(1,1,"test1","test description");
    private final Photo PHOTO_6 = new Photo(6,2,"test6","test description");


    private JdbcPhotoDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcPhotoDao(jdbcTemplate);
    }

//    @Test
//    public void getPhotoByPetID_for_pet_1_returns_3(){
//        List<Photo> photos = sut.photosByPetID(1);
//        Assert.assertNotNull(photos);
//        Assert.assertEquals(3,photos.size());
//        assertPhotosMatch(PHOTO_1,photos.get(0));
//    }
//
//    @Test
//    public void getPhotoByPetID_for_pet_2_returns_3(){
//        List<Photo> photos = sut.photosByPetID(2);
//        Assert.assertNotNull(photos);
//        Assert.assertEquals(3,photos.size());
//        assertPhotosMatch(PHOTO_6,photos.get(2));
//    }

    private void assertPhotosMatch(Photo expected, Photo actual){
        Assert.assertEquals(expected.getPhotoID(),actual.getPhotoID());
        Assert.assertEquals(expected.getPetID(),actual.getPetID());
        Assert.assertEquals(expected.getSource(),actual.getSource());
        Assert.assertEquals(expected.getDescription(),actual.getDescription());
    }


}
