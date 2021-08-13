package com.example.findyourdog;

import java.io.Serializable;

public class F_Dog_DTO implements Serializable {

    private String board_num;
    private String id;
    private String type;
    private String date;
    private String time;
    private String city;
    private String place;
    private String tel;
    private String picture;


    private String kind;
    private String content;
    private String gender;
    private String age;
    private String color;
    private String weight;

    public F_Dog_DTO(String id, String type, String date, String time, String city, String place, String tel, String picture, String kind, String content, String gender, String age, String color, String weight) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.time = time;
        this.city = city;
        this.place = place;
        this.tel = tel;
        this.picture = picture;
        this.kind = kind;
        this.content = content;
        this.gender = gender;
        this.age = age;
        this.color = color;
        this.weight = weight;
    }

    public F_Dog_DTO(String board_num, String picture) {
        this.board_num = board_num;
        this.picture = picture;
    }

    public String getBoard_num() {
        return board_num;
    }

    public void setBoard_num(String board_num) {
        this.board_num = board_num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
