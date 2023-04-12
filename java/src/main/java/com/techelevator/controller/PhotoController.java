package com.techelevator.controller;

import com.techelevator.dao.PhotoDao;
import com.techelevator.model.Photo;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@PreAuthorize("permitAll()")
@CrossOrigin
public class PhotoController {
    private final PhotoDao photoDao;

    public PhotoController(PhotoDao photoDao) {
        this.photoDao = photoDao;
    }

    @GetMapping("/photos")
    public List<Photo> getPhotosByID(){
        if(photoDao.getAllPhotos()==null){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No pictures found.");
        }
        return photoDao.getAllPhotos();
    }

}
