package com.techelevator.dao;

import com.techelevator.model.Photo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPhotoDao implements PhotoDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcPhotoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Photo> getAllPhotos() {
        List<Photo> photos = new ArrayList<>();
        String sql = "SELECT * FROM photos;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            photos.add(mapRowToPhoto(results));
        }
        return photos;
    }

    public Photo mapRowToPhoto(SqlRowSet results){
        Photo photo = new Photo();
        photo.setPhotoID(results.getInt("photo_id"));
        photo.setPetID(results.getInt("pet_id"));
        photo.setSource(results.getString("source"));
        photo.setDescription(results.getString("description"));
        return photo;
    }
}
