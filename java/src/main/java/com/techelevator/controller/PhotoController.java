package com.techelevator.controller;

import com.techelevator.dao.PhotoDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Authority;
import com.techelevator.model.Photo;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@PreAuthorize("permitAll()")
@CrossOrigin
public class PhotoController {
    private final PhotoDao photoDao;
    private final UserDao userDao;


    public PhotoController(PhotoDao photoDao, UserDao userDao) {
        this.photoDao = photoDao;
        this.userDao = userDao;
    }


    @GetMapping("/photos")
    public List<Photo> getPhotosByID(){
        if(photoDao.getAllPhotos()==null){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No pictures found.");
        }
        return photoDao.getAllPhotos();
    }

   @PostMapping("/photos/add")
    public void addPhoto(@RequestBody @Valid Photo photo) throws IllegalAccessException {
            if (photo != null){
                if(photoDao.addNewPhoto(photo) == null) {
                    throw  new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED,"Error");
                }
            }
        }
   }

