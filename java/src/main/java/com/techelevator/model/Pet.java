package com.techelevator.model;


import java.time.LocalDate;

public class Pet {
    private int petID;
    private String name;
    private LocalDate DOB;
    private String breed;
    private String color;
    private boolean isVaccinated;
    private String sex;
    private String status;
    private LocalDate entryDate;
    private LocalDate adoptionDate;
    private String description;

    public Pet(int petID, String name, LocalDate DOB, String breed, String color, boolean isVaccinated, String sex, String status, LocalDate entryDate, LocalDate adoptionDate, String description) {
        this.petID = petID;
        this.name = name;
        this.DOB = DOB;
        this.breed = breed;
        this.color = color;
        this.isVaccinated = isVaccinated;
        this.sex = sex;
        this.status = status;
        this.entryDate = entryDate;
        this.adoptionDate = adoptionDate;
        this.description = description;
    }

    public Pet(){}

    public Pet(int petID, String name, String breed, String color, boolean isVaccinated, String sex, String status, String description) {
        this.petID = petID;
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.isVaccinated = isVaccinated;
        this.sex = sex;
        this.status = status;
        this.description = description;
    }

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
