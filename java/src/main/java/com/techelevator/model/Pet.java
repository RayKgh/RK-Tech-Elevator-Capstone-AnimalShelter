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
        this.setAdoptionStatus(adoptionStatus);
        this.entryDate = entryDate;
        this.adoptionDate = adoptionDate;
        this.petDescription = petDescription;
    }

    public Pet() {
    }

    //ignores leap years but should be good enough. I don't think sloths live that long.
//    public int getAge() {
//        LocalDate thisDate = LocalDate.now();
//        int days = thisDate.getYear() * 365 + thisDate.getDayOfYear();
//        int daysAlive = DOB.getYear() * 365 + DOB.getDayOfYear();
//        return (days - daysAlive) / 365;
//    }
//
//    public int getTimeInShelter() {
//        LocalDate thisDate = LocalDate.now();
//        int days = thisDate.getYear() * 365 + thisDate.getDayOfYear();
//        int daysAlive = entryDate.getYear() * 365 + entryDate.getDayOfYear();
//        return (days - daysAlive) / 365;
//    }


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
        if (adoptionStatus.equals("Available") || adoptionStatus.equals("Adopted")) {
            this.adoptionStatus = adoptionStatus;
        } else {
            throw new IllegalArgumentException("adoption status should be either 'Available' or 'Adopted'");
        }
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
