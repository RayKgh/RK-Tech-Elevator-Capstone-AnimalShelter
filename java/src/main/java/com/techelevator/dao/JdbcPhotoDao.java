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

    public Photo getPhotoById(int photoId) {
        String sql = "SELECT * FROM photos WHERE photo_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, photoId);
        if (results.next()) {
            return mapRowToPhoto(results);
        } else {
            return null;
        }
    }

    @Override
    public Photo addNewPhoto(Photo photo) {
       String sql = "INSERT INTO photos (pet_id, source, description)" +
               "VALUES (?,?,?)" + "RETURNING photo_id";
       Integer newPhotoId = jdbcTemplate.queryForObject(sql, Integer.class, photo.getPetID(), photo.getSource(),photo.getDescription());
       if(newPhotoId != null) {
           return getPhotoById(newPhotoId);
       } else{
           return null;
       }
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
