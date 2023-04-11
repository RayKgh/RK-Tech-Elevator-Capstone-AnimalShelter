package com.techelevator.model;

public class Photo {
    private int photoID;
    private int petID;
    private String source;
    private String description;

    public int getPhotoID() {
        return photoID;
    }

    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }

    public Photo() {
    }

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Photo(int photoID, int petID, String source, String description) {
        this.photoID = photoID;
        this.petID = petID;
        this.source = source;
        this.description = description;
    }
}
