package com.example.findyourdog;

public class ShelterItem {
    private String shelter_name;
    private String shelter_addr;

    public ShelterItem(String shelter_name, String shelter_addr) {
        this.shelter_name = shelter_name;
        this.shelter_addr = shelter_addr;
    }

    public String getShelter_name() {
        return shelter_name;
    }

    public void setShelter_name(String shelter_name) {
        this.shelter_name = shelter_name;
    }

    public String getShelter_addr() {
        return shelter_addr;
    }

    public void setShelter_addr(String shelter_addr) {
        this.shelter_addr = shelter_addr;
    }
}
