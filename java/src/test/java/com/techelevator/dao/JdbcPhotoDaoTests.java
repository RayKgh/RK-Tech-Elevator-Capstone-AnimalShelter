package com.techelevator.dao;

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

    @Test
    public void getPhotoByPetID_for_pet_1_returns_6(){
        List<Photo> photos = sut.getAllPhotos();
        Assert.assertNotNull(photos);
        Assert.assertEquals(6,photos.size());
        assertPhotosMatch(PHOTO_1,photos.get(0));
        assertPhotosMatch(PHOTO_6,photos.get(5));
    }

    private void assertPhotosMatch(Photo expected, Photo actual){
        Assert.assertEquals(expected.getPhotoID(),actual.getPhotoID());
        Assert.assertEquals(expected.getPetID(),actual.getPetID());
        Assert.assertEquals(expected.getSource(),actual.getSource());
        Assert.assertEquals(expected.getDescription(),actual.getDescription());
    }


}
