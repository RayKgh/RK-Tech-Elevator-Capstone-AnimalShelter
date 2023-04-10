package com.techelevator.model;


import java.time.LocalDate;

public class Pet {
    private int petID;
    private String petName;
    private LocalDate DOB;
    private String breed;
    private String color;
    private boolean isVaccinated;
    private String sex;
    private String adoptionStatus;
    private LocalDate entryDate;
    private LocalDate adoptionDate;
    private String petDescription;

    public Pet(int petID, String petName, LocalDate DOB, String breed, String color, boolean isVaccinated, String sex, String adoptionStatus, LocalDate entryDate, LocalDate adoptionDate, String petDescription) {
        this.petID = petID;
        this.petName = petName;
        this.DOB = DOB;
        this.breed = breed;
        this.color = color;
        this.isVaccinated = isVaccinated;
        this.sex = sex;
        this.adoptionStatus = adoptionStatus;
        this.entryDate = entryDate;
        this.adoptionDate = adoptionDate;
        this.petDescription = petDescription;
    }

    public Pet(){}

    public Pet(int petID, String petName, String breed, String color, boolean isVaccinated, String sex, String adoptionStatus, String petDescription) {
        this.petID = petID;
        this.petName = petName;
        this.breed = breed;
        this.color = color;
        this.isVaccinated = isVaccinated;
        this.sex = sex;
        this.adoptionStatus = adoptionStatus;
        this.petDescription = petDescription;
    }

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAdoptionStatus() {
        return adoptionStatus;
    }

    public void setAdoptionStatus(String adoptionStatus) {
        this.adoptionStatus = adoptionStatus;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDate getAdoptionDate() {
        return adoptionDate;
    }

    public void setAdoptionDate(LocalDate adoptionDate) {
        this.adoptionDate = adoptionDate;
    }

    public String getPetDescription() {
        return petDescription;
    }

    public void setPetDescription(String petDescription) {
        this.petDescription = petDescription;
    }
}
