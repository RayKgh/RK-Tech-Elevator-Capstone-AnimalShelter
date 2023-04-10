package com.techelevator.model;

import java.time.LocalDate;

public class PetDto {
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

    public PetDto(int petID, String name, LocalDate DOB, String breed, String color, boolean isVaccinated, String sex, String status, LocalDate entryDate, LocalDate adoptionDate, String description) {
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

}
