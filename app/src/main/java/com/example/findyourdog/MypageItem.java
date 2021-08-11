package com.example.findyourdog;

public class MypageItem {
    private String dog_name;
    private String result;

    public MypageItem(String dog_name, String result) {
        this.dog_name = dog_name;
        this.result = result;
    }

    public String getDog_name() {
        return dog_name;
    }

    public void setDog_name(String dog_name) {
        this.dog_name = dog_name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
